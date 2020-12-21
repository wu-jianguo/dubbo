package com.xiaolao.consumer.controllers;


import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaolao.consumer.service.IOrderService;
import com.xiaolao.provider.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Reference
    private IProviderService providerService;

    @Resource
    private IOrderService orderService;

    @GetMapping("test")
    public String test(){
        return providerService.test();
    }


    @GetMapping("tx")
    public void tx(){
        orderService.addOrderAndReduceStock();
    }
}
