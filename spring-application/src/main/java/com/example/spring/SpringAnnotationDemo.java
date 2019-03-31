package com.example.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author lanwp
 * @Date 2019/3/29
 */
//@Configuration
public class SpringAnnotationDemo {
    public static void main(String[] args) {
        // XML 配置文件驱动 ClassPathXmlApplicationContext
        // Annotation 驱动
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册一个Configuration Class = SpringAnnotationDemo
        context.register(SpringAnnotationDemo.class);
        // 上下文启动
        context.refresh();

        System.out.println(context.getBean(SpringAnnotationDemo.class));
    }
}
