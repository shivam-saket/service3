package com.centime.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = false)
@PropertySource(value = {"classpath:application.properties"})
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }
}
