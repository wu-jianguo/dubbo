package com.xiaolao.provider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.xiaolao.provider.service.IProviderService;
import org.springframework.stereotype.Component;


@Component
@Service
public class ProviderServiceImpl implements IProviderService {


    @Override
    public String test() {
        return "Hello world999";
    }
}
