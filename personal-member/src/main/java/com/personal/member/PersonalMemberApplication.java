package com.personal.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.personal.member.fegin")
public class PersonalMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalMemberApplication.class, args);
    }

}
