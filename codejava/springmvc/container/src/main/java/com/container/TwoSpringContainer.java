package com.container;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.*;

@Configuration
class FirstConfig {
    @Bean
    public FirstBean firstBean() {
        return new FirstBean();
    }
}

@Configuration
class SecondConfig {
    @Bean
    public SecondBean secondBean() {
        return new SecondBean();
    }
}

class FirstBean {
    public void doSomething() {
        System.out.println("Data From first container");
    }
}

class SecondBean {
    public void doSomething() {
        System.out.println("Data From second container");
    }
}

public class TwoSpringContainer {
    public static void main(String[] args) {
        // First Spring container
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext();
        context1.register(FirstConfig.class);
        context1.refresh();

        FirstBean firstBean = context1.getBean(FirstBean.class);
        firstBean.doSomething();

        // Second Spring container
        AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext();
        context2.register(SecondConfig.class);
        context2.refresh();

        SecondBean secondBean = context2.getBean(SecondBean.class);
        secondBean.doSomething();

        // Close the containers
        context1.close();
        context2.close();
    }
}
