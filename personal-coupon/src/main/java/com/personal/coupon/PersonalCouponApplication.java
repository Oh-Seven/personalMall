package com.personal.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PersonalCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalCouponApplication.class, args);
    }

}
