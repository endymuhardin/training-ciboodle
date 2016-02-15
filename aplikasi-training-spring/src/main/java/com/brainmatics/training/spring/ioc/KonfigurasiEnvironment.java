package com.brainmatics.training.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(
	basePackages="com.brainmatics.training.spring.ioc"
)
@PropertySource("classpath:koneksi.properties")
public class KonfigurasiEnvironment {
	
	@Autowired
	private Environment env;
	
	@Bean
	public KoneksiDatabase getKoneksi(){
		KoneksiDatabase koneksi = new KoneksiDatabase();
		koneksi.setHost(env.getProperty("host"));
		koneksi.setPort(Integer.valueOf(env.getProperty("port")));
		koneksi.setNamaDatabase(env.getProperty("name"));
		koneksi.setUsername(env.getProperty("username"));
		koneksi.setPassword(env.getProperty("password"));
		return koneksi;
	}
}
