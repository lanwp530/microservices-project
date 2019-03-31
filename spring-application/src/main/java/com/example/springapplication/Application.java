package com.example.springapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);

        // 第一种写法
        /*new SpringApplicationBuilder(Application.class)
                // 单元测试是 PORT=RANDOM
                .properties("server.port=0") // 随机像OS要一个端口
                .run(args);*/

        // 第二种写法，等同
        SpringApplication springApplication = new SpringApplication(Application.class);
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("server.port", 0);
        springApplication.setDefaultProperties(properties);
        // 设置为非web应用
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
    }

}
