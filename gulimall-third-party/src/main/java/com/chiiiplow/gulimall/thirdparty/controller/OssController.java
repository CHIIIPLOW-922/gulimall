package com.chiiiplow.gulimall.thirdparty.controller;


import com.chiiiplow.common.utils.R;
import io.minio.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OssController {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.host}")
    private String host;

    @Value("${minio.bucketName}")
    private String bucketName;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.secretKey}")
    private String secretKey;



    private void creatBucket(MinioClient minioClient) throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    @RequestMapping(path = "/oss/upload", method = RequestMethod.POST)
    public void upload(@RequestParam MultipartFile file) {
        try (InputStream in = file.getInputStream()) {
            MinioClient minioClient = MinioClient.builder().endpoint(host).credentials(accessKey, secretKey).build();
            creatBucket(minioClient);
            minioClient.uploadObject(UploadObjectArgs.builder()
                    .bucket(bucketName)
                    .object(file.getOriginalFilename())
                    .contentType(file.getContentType())
                    .build());
            System.err.println("上传成功");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    @RequestMapping("/oss/policy")
    public R policy() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = format + "/";
        Map<String, String> respMap = null;
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            String fakePolicy = UUID.randomUUID().toString().replace("-", "");
            String postSignature = UUID.randomUUID().toString().replace("-", "");
            respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessKey);
            respMap.put("policy", fakePolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", url);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new R().put("data", respMap);
    }
}
