package com.xjsxj.dubbo.demo2.biz;

import com.xjsxj.dubbo.facade.Demo2Service;
import org.apache.dubbo.rpc.RpcContext;

public class Demo2ServiceImpl implements Demo2Service {
    public String sayHello(String name) {
        System.out.println("Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}
