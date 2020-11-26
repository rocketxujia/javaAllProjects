package com.xjsxj.dubbo.demo3;

import com.xjsxj.dubbo.facade.Demo3Service;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class Demo3ConsumerApp {
    public static void main(String[] args) {
        Demo3Service demo3Service = getService();
        String msg = demo3Service.sayHello("Test");
        System.out.println("Demo3Service服务调用成功，返回MSG：" + msg);
    }

    private static Demo3Service getService() {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("java-dubbo-demo3-api-consumer");
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");
        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
        // 引用远程服务
        ReferenceConfig<Demo3Service> reference = new ReferenceConfig<Demo3Service>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(Demo3Service.class);
        // 和本地bean一样使用Demo3Service
        Demo3Service demo3Service = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
        return demo3Service;
    }
}
