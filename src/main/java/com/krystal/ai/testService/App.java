package com.krystal.ai.testService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = false)
@EnableScheduling
@PropertySource(value = {"classpath:application.properties"})
public class App {
   public static void main(String[] args) {
      SpringApplication.run(App.class, args);
   }
}
