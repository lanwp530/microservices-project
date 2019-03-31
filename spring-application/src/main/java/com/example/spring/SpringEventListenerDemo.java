package com.example.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @Author lanwp
 * @Date 2019/3/30
 */
public class SpringEventListenerDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();

        addListener(context);
        // 启动spring上下文
        // ContextRefreshedEvent事件
        context.refresh();
        //　Spring应用上下文发布事件
        // PayloadApplicationEvent
        context.publishEvent("Hello World"); // 推送一个Hello World事件


        context.publishEvent(new MyEvent("my event")); // 推送一个自定义事件

        // 关闭Spring上下文
        // ContextClosedEvent
        context.close();
    }

    private static void addListener(GenericApplicationContext context) {
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                System.out.println("监听所有事件" + event);
            }
        });

        // 增加自定义监听
        context.addApplicationListener(new MyContextClosedEvent());
    }

    private static class MyEvent extends ApplicationEvent {

        public MyEvent(Object source) {
            super(source);
        }
    }

    private static class MyContextClosedEvent implements ApplicationListener<ContextClosedEvent> {

        @Override
        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
            System.out.println("自定义ContextClosedEvent事件");
        }
    }
}
