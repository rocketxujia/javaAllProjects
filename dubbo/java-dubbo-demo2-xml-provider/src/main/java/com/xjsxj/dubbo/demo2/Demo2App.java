package com.xjsxj.dubbo.demo2;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Demo2App {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext annotationConfigApplicationContext = new ClassPathXmlApplicationContext("classpath:/provider.xml");
        annotationConfigApplicationContext.start();
        System.out.println("java-dubbo-demo2-xml-provider 服务提供中...");
        System.in.read();
        System.out.println("java-dubbo-demo2-xml-provider 服务停止");
    }
}
