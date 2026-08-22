package com.jt.dependency_injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")
@Primary
public class PetrolEngine implements Engine{

    @Override
    public void startEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol engine starting"); 
    }

    @Override
    public void stopEngine() {
        // TODO Auto-generated method stub
        System.out.println("Petrol engine stopping");
    }
    
}
