package com.brainmatics.training.demo;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.brainmatics.training.config.Konfigurasi;
import com.brainmatics.training.dao.PesertaDao;
import com.brainmatics.training.entity.Peserta;

public class Aplikasi {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(Konfigurasi.class);
		
		Peserta p = new Peserta();
		p.setNama("Endy");
		p.setKode("P-001");
		p.setTanggalLahir(new Date());
		
		PesertaDao pd = ac.getBean(PesertaDao.class);
		pd.simpan(p);
		System.out.println("ID Peserta : "+p.getId());
	}
}