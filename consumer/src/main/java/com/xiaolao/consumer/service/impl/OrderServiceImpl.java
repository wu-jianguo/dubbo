package com.xiaolao.consumer.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaolao.consumer.bean.Order;
import com.xiaolao.consumer.dao.OrderDao;
import com.xiaolao.consumer.service.IOrderService;
import com.xiaolao.provider.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements IOrderService {

    @Reference
    IStorageService storageService;

    @Resource
    private OrderDao orderDao;

    @Override
    @GlobalTransactional
    public void addOrderAndReduceStock() {
        Order order = new Order();
        order.setOrderNo("ZW");
        order.setUserId("X");
        order.setCount(1);
        order.setAmount(2);
        order.setCommodityCode("123456789");
        orderDao.insert(order);
        storageService.reduceStock();
        System.out.println(1/0);
    }
}
