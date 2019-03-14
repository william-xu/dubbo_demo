package com.example.dubbo;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.example.dubbo.hello.HelloService;
import com.example.dubbo.hello.HelloServiceImpl;

public class DubboD1Provider {
    public static void main(String[] args) throws IOException {
        ServiceConfig<HelloService> service = new ServiceConfig<>(); // #1
        service.setApplication(new ApplicationConfig("first-dubbo-provider")); // #2
        service.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234")); // #3
        service.setInterface(HelloService.class); // #4
        service.setRef(new HelloServiceImpl()); // #5
        service.export(); // #6
        System.in.read(); // #7
    }
}
