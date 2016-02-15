package com.brainmatics.training.spring.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
	basePackages="com.brainmatics.training.spring.ioc"
)
public class Konfigurasi {
	
	@Bean
	public KoneksiDatabase getKoneksi(){
		KoneksiDatabase koneksi = new KoneksiDatabase();
		koneksi.setHost("localhost");
		koneksi.setPort(3306);
		koneksi.setNamaDatabase("training");
		koneksi.setUsername("scott");
		koneksi.setPassword("tiger");
		return koneksi;
	}
}
