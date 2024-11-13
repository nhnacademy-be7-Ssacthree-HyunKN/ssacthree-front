package com.nhnacademy.mini_dooray.ssacthree_front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SsacthreeFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsacthreeFrontApplication.class, args);
    }

}
