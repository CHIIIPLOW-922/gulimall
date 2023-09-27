package com.chiiiplow.gulimall.thirdparty.controller;


import com.chiiiplow.common.utils.R;
import com.chiiiplow.gulimall.thirdparty.config.MinioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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


    @Autowired
    private MinioConfig minioConfig;



    @RequestMapping(path = "/oss/upload", method = RequestMethod.POST)
    public void upload(@RequestParam(name = "file") MultipartFile file) {
        try {
            minioConfig.putObject(file);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @RequestMapping(path="/oss/listVideoName",method=RequestMethod.GET)
    public R listVideoName(){
        try{
            List<String> list = minioConfig.listObjectNames(bucketName).stream().filter(s -> s.endsWith(".mp4")).collect(Collectors.toList());
            Collections.shuffle(list);
            return R.ok().put("data",list.get(0));
        }catch (Exception e){
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
