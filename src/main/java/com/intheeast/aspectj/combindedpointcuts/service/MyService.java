package com.intheeast.aspectj.combindedpointcuts.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void performBusinessLogic() {
        System.out.println("Performing business logic");
    }
}
