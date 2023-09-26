package com.chiiiplow.gulimall.thirdparty.controller;


import com.chiiiplow.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class OssController {

    @Value("${minio.url}")
    private String host;

    @Value("${minio.accessKey}")
    private String accessKey;

    @Value("${minio.bucketName}")
    private String bucketName;





    @RequestMapping("/oss/policy")
    public R policy() {
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = format + "/";
        Map<String, String> respMap = null;
        try {
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);
            String fakePolicy = UUID.randomUUID().toString().replace("-", "");
            String postSignature = UUID.randomUUID().toString().replace("-","");
            respMap = new LinkedHashMap<String,String>();
            respMap.put("accessid",accessKey);
            respMap.put("policy",fakePolicy);
            respMap.put("signature",postSignature);
            respMap.put("dir",dir);
            respMap.put("host",host);
            respMap.put("expire",String.valueOf(expireEndTime/1000));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new R().put("data",respMap);
    }
}
