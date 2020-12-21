package com.xiaolao.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaolao.provider.bean.Storage;
import com.xiaolao.provider.dao.StorageDao;
import com.xiaolao.provider.service.IStorageService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Service
public class StorageServiceImpl implements IStorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void reduceStock() {
        Storage storage = new Storage();
        storage.setCount(1);
        storage.setName("xl");
        storage.setCommodityCode("2662");
        storageDao.insert(storage);
        System.out.println(1/0);
    }
}
