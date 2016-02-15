package com.brainmatics.training.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSpringIoc {
	public static void main(String[] args) {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("classpath:ioc.xml");
		
		KoneksiDatabase k = ac.getBean(KoneksiDatabase.class);
		System.out.println(k.getPort());
		
		AbsensiDao ad = ac.getBean(AbsensiDao.class);
		ad.simpan();
		
		PesertaDao pd = (PesertaDao) ac.getBean("pesertaDao");
		pd.simpan();
	}
}
