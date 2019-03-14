package com.example.dubbo;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

import com.example.dubbo.hello.HelloService;

public class DubboD1Consumer {
    public static void main(String[] args) {

        ReferenceConfig<HelloService> reference = new ReferenceConfig<>(); // #1
        ApplicationConfig config = new ApplicationConfig("first-dubbo-client");
        config.setQosEnable(false);
        reference.setApplication(config); // #2
        reference.setRegistry(new RegistryConfig("multicast://224.5.6.7:1234")); // #3
        reference.setInterface(HelloService.class); // #4
        HelloService greetingsService = reference.get(); // #5
        String message = greetingsService.sayHello("dubbo"); // #6
        System.out.println("\n" + message + "\n"); // #7
    }
}
