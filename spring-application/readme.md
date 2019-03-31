# 第一节 SpringApplication

# 主要内容

## 自定义 SpringApplication

### `SpringApplication`

两种配置等同

SpringApplication

```java
SpringApplication springApplication = new SpringApplication(Application.class);
Map<String, Object> properties = new LinkedHashMap<>();
properties.put("server.port", 0);
springApplication.setDefaultProperties(properties);
springApplication.run(args);
```

SpringApplicationBuilder

```java
new SpringApplicationBuilder(Application.class)
                // 单元测试是 PORT=RANDOM
                .properties("server.port=0") // 随机像OS要一个端口
                .run(args);
```



```java
public class SpringAnnotationDemo {
    public static void main(String[] args) {
```



