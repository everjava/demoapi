package io.tempo.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EnableFeignClients
@SpringBootApplication
public class DemoapiApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoapiApp.class, args);
    }

}
