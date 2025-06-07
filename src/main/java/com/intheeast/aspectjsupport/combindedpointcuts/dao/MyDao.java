package com.intheeast.aspectjsupport.combindedpointcuts.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MyDao {

    public void accessData() {
        System.out.println("Accessing data");
    }
}
