package com.xjsxj.dubbo.demo3;


import com.xjsxj.dubbo.demo3.biz.Demo3ServiceImpl;
import com.xjsxj.dubbo.facade.Demo3Service;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import java.io.IOException;

public class Demo3App {
    public static void main(String[] args) throws IOException {
        exportProvider();
        System.out.println("java-dubbo-demo2-xml-provider 服务提供中...");
        System.in.read();
        System.out.println("java-dubbo-demo2-xml-provider 服务停止");
    }

    private static void exportProvider() {
        // 服务实现
        Demo3Service demo3Service  = new Demo3ServiceImpl();
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("java-dubbo-demo3-api-provider");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");
        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20893);
        // 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
        // 服务提供者暴露服务配置
        ServiceConfig<Demo3Service> service = new ServiceConfig<Demo3Service>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(Demo3Service.class);
        service.setRef(demo3Service);
        // 暴露及注册服务
        service.export();
    }
}
