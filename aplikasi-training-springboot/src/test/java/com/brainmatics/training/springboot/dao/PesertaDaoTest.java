package com.brainmatics.training.springboot.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brainmatics.training.springboot.AplikasiTrainingSpringbootApplication;
import com.brainmatics.training.springboot.entity.Peserta;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AplikasiTrainingSpringbootApplication.class)
@Sql(scripts={"/delete-sample-data.sql","/sample-peserta.sql"})
public class PesertaDaoTest {
	@Autowired
	private PesertaDao pesertaDao;
	
	@Test
	public void testSimpan(){
		Peserta p = new Peserta();
		p.setNama("Endy");
		p.setKode("P-102");
		p.setTanggalLahir(new Date());
		
		Assert.assertNull(p.getId());
		pesertaDao.save(p);
		Assert.assertNotNull(p.getId());
	}
	
	@Test
	public void testCariById(){
		Integer id = 99;
		Peserta px = pesertaDao.findOne(id);
		Assert.assertNotNull(px);
		Assert.assertEquals("P-009", px.getKode());
		Assert.assertEquals("Peserta 009", px.getNama());
		
		Assert.assertNull(pesertaDao.findOne(101));
		
	}
	
	@Test
	public void testDeleteById(){
		Assert.assertNotNull(pesertaDao.findOne(99));
		pesertaDao.delete(99);
		Assert.assertNull(pesertaDao.findOne(99));
	}
}
