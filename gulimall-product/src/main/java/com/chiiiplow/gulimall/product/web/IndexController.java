package com.chiiiplow.gulimall.product.web;


import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class IndexController {

    @Autowired
    private RedissonClient redisson;

    @GetMapping("/lockDoor")
    public String lockDoor() throws InterruptedException{
        RCountDownLatch lockDoor = redisson.getCountDownLatch("lockDoor");
        lockDoor.trySetCount(5);
        lockDoor.await();
        return "lockDoor success";
    }


    @GetMapping("/gogogo/{id}")
    public String gogogo(@PathVariable("id") Long id) throws InterruptedException{
        RCountDownLatch lockDoor = redisson.getCountDownLatch("lockDoor");
        lockDoor.countDown();
        return id+"gogogo success";
    }




}
