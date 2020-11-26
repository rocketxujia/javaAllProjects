package com.xjsxj.dubbo.demo2;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        annotationConfigApplicationContext.start();
        System.out.println("java-dubbo-demo1-annotation-provider 服务提供中...");
        System.in.read();
        System.out.println("java-dubbo-demo1-annotation-provider 服务停止");
    }

    /**
     * 注解形式
     */
    @Configuration
    @EnableDubbo(scanBasePackages = "com.xjsxj.dubbo.demo2.biz")
    @PropertySource("classpath:/application.properties")
    static class ProviderConfiguration {
    }
}
