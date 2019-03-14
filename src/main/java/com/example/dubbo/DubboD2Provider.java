package com.example.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这个示例使用zookeeper，运行前需要先配置或者修改成广播
 * @author nozuodie
 *
 */
public class DubboD2Provider {
    public static void main(String[] args) throws Exception {
        //Prevent to get IPV6 address,this way only work in debug mode
        //But you can pass use -Djava.net.preferIPv4Stack=true,then it work well whether in debug mode or not
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/dubbo-provider.xml"});
        context.start();
        System.in.read(); // press any key to exit
    }    
}
