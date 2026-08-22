package com.jt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
    private Greeting greeting;

    public Greet(){
        System.out.println("Greet object is constructed.");
    }

    @Autowired
    public void setGreeting(Greeting greeting){
        System.out.println("Greeting object is Injected");
        this.greeting = greeting;
    }

    @PostConstruct
    public void init(){
        System.out.println("Bean is initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Greet Bean is destroyrd");
    }

    public void greet(){
        System.out.println("Hello Everyone!");
        // greeting.sayHii();
    }
}
