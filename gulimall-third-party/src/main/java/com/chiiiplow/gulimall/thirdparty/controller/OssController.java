package com.chiiiplow.gulimall.thirdparty.controller;


import com.chiiiplow.common.utils.R;
import com.chiiiplow.gulimall.thirdparty.config.MinioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
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

    private static final String textFlieName="test.txt";


    @Autowired
    private MinioConfig minioConfig;



    @RequestMapping(path = "/oss/upload", method = RequestMethod.POST)
    public R upload(@RequestParam(name = "file") MultipartFile file) {
        try {
            String name = minioConfig.putObject(file);
            return R.ok().put("data", url + "/" + name);
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

    @PutMapping("/oss/textFile")
    public R updateTextFile(@RequestBody String text){
        try {
            boolean exists = minioConfig.statObject(bucketName,textFlieName);
            if (!exists) {
                return R.error(400,"文件不存在");
            }
            // 读取原文件内容
//            InputStream inputStream = minioConfig.getObject(bucketName,textFlieName);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String fileContent = reader.lines().collect(Collectors.joining("\n"));
//            reader.close();

            // 合并新文本内容
            //String updatedContent = fileContent + "\n" + text;
            // 将更新后的文本内容写回到文件中
            ByteArrayInputStream updatedStream = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            minioConfig.putTextObject(bucketName,textFlieName,updatedStream);
            return R.ok("修改成功").put("data",text);
        }catch (Exception e){
            return R.error("修改失败");
        }

    }
    /*
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
    */
}
