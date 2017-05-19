package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Main.class, args);
		
		String[] beanNames =  applicationContext.getBeanDefinitionNames();
		System.out.println("加载beans的个数：" + beanNames.length);
		for(String bn : beanNames){
			System.out.println(bn);
		}
		
		String[] serviceNames = applicationContext.getBeanNamesForAnnotation(Service.class);
		System.out.println("加载service的个数：" + serviceNames.length);
		for(String sn : serviceNames){
			System.out.println(sn);
		}
		
	}
	
}
