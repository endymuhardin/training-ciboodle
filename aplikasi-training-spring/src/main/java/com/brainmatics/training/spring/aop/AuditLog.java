package com.brainmatics.training.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AuditLog implements MethodInterceptor {

	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("Sebelum menjalankan method di target object");
		
		String namaMethod = method.getMethod().getName();
		String namaClass = method.getMethod().getDeclaringClass().getName();
		
		System.out.println("Menjalankan method "+namaMethod+ " dalam class "+namaClass);
		System.out.println("Jumlah argumen : "+method.getArguments().length);
		System.out.println("Isi argumen pertama : "+method.getArguments()[0]);
		
		Object hasil = method.proceed();
		System.out.println("Setelah menjalankan method di target object");
		return hasil;
	}
	
}
