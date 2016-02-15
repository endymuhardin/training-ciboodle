package com.brainmatics.training.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("classpath:aop.xml");
		
		TrainingService ts = (TrainingService) ac.getBean("trainingService");
		ts.registrasi("Endy");
	}
}
