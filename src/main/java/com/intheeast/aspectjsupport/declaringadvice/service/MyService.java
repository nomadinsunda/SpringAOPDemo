package com.intheeast.aspectjsupport.declaringadvice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	// @AfterThrowing 테스트를 위해서는 다음 주석처리된 코드를 실행시키면 됨
//    public void performTask() throws IndexOutOfBoundsException{
//        System.out.println("Performing a task...");
//        
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//                
//        list.get(3);        
//    }
    
	// @AfterThrowing 어드바이스가 적용되지 않음
	// : 예외를 처리하였기 때문에!!!
	// 정상적인 실행을 위해 예외를 처리하였음
    public void performTask() {
        System.out.println("Performing a task...");
        // 실제 작업 수행 로직
        
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");                
        
        try {
        	list.get(3);
        } catch(IndexOutOfBoundsException e) {
        	System.out.println(e.getStackTrace());
        }        
    }
}