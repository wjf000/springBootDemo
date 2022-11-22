package com.wjf.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
        // 获取本机IP地址
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("IP:" +address);
    }
}
