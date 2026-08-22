package com.jt.dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // private Engine engine = new Engine();
    
    // DI
    // 1. Field Based Injection
    // @Autowired
    // private Engine engine;

    // 2. Setter Method Based Injection
    // private Engine engine;
    // @Autowired
    // public void setEngine(Engine engine){
    //     // System.out.println("Parameter engine" + engine);
    //     // System.out.println("Variable engine" + this.engine);
    //     this.engine = engine;
    // }

    // 3. Constructor based Injection
    private Engine engine;

    @Autowired
    public Car(@Qualifier("dieselEngine") Engine engine){
        this.engine = engine;
        System.out.println("Parameterized constructor");
    }

    public Car(){
        System.out.println("Non parameterized constructor");
    }

    public void startCar(){
        // Engine engine = new Engine();
        engine.startEngine();

        System.out.println("Car is started");
    }

    public void stopCar(){
        // Engine engine = new Engine();
        engine.stopEngine();

        System.out.println("Car is stopped");
    }
}
