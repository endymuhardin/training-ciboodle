package com.brainmatics.training.springboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.brainmatics.training.springboot.AplikasiTrainingSpringbootApplication;
import com.brainmatics.training.springboot.entity.Instruktur;
import com.brainmatics.training.springboot.entity.Kelas;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AplikasiTrainingSpringbootApplication.class)
@Sql(scripts={
		"/delete-sample-data.sql", 
		"/sample-peserta.sql", 
		"/sample-instruktur.sql", 
		"/sample-kelas.sql"
})
public class KelasDaoTest {
	@Autowired private InstrukturDao instrukturDao;
	@Autowired private KelasDao kelasDao;
	@Autowired private PesertaDao pesertaDao;
	
	@Autowired private DataSource dataSource;
	
	@Test
	public void testSimpan() throws Exception{
		Kelas k = new Kelas();
		k.setKode("K-99");
		k.setNama("Kelas Test");
		
		Instruktur i = instrukturDao.findOne(99);
		k.setInstruktur(i);
		SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
		k.setTanggalMulai(frm.parse("2016-03-01"));
		k.setTanggalSelesai(frm.parse("2016-03-05"));
		
		k.getDaftarPeserta().add(pesertaDao.findOne(99));
		k.getDaftarPeserta().add(pesertaDao.findOne(98));
		
		kelasDao.save(k);
		
		Assert.assertNotNull(k.getId());
		
		String sql = "select count(*) from peserta_training where id_kelas = ?";
		Connection c = dataSource.getConnection();
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, k.getId());
		ResultSet rs = ps.executeQuery();
		Assert.assertTrue(rs.next());
		Long hasil = rs.getLong(1);
		rs.close();
		c.close();
		Assert.assertTrue(hasil == 2);
	}
	
	@Test @Transactional
	public void testCariById(){
		Kelas k = kelasDao.findOne(99);
		Assert.assertNotNull(k);
		Assert.assertTrue(k.getDaftarPeserta().size() == 4);
	}
}
