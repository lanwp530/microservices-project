package com.example.springapplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author lanwp
 * @Date 2019/3/30
 */
@SpringBootApplication
public class SpringBootEventDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootEventDemo.class)
                .listeners(event -> { // 增加监听器
                    System.err.println("监听事件：" + event);
                }).run(args).close(); // 运行

        /**
         * 1. ApplicationStartingEvent
         * 2. ApplicationEnvironmentPreparedEvent
         * 3. ApplicationContextInitializedEvent
         * 4. ApplicationPreparedEvent
         * 5. ContextRefreshedEvent
         * 6. ServletWebServerInitializedEvent // 未开启web则没有此事件
         * 7. ApplicationStartedEvent
         * 8. ApplicationReadyEvent
         * 9. ContextClosedEvent
         */
    }
}
