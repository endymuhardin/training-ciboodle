package com.brainmatics.training.springboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.brainmatics.training.springboot.entity.Peserta;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AplikasiTrainingSpringbootApplication.class)
@Sql(scripts={
		"/delete-sample-data.sql", 
		"/sample-peserta.sql", 
		"/sample-instruktur.sql", 
		"/sample-materi.sql",
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
	
	@Test
	public void testCariKelasByNamaInstruktur(){
		List<Kelas> hasil = kelasDao.findByInstrukturNamaContaining("001");
		Assert.assertFalse(hasil.isEmpty());
		
		List<Kelas> hasil2 = kelasDao.findByInstrukturNamaContaining("003");
		Assert.assertTrue(hasil2.isEmpty());
		
	}
	
	@Test
	public void testCariKelasByTanggalMulai() throws Exception {
		SimpleDateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
		Date mulai = frm.parse("2016-01-30");
		Date sampai = frm.parse("2016-02-10");
		List<Kelas> hasil = kelasDao.findByTanggalMulaiAntara(mulai, sampai);
		Assert.assertFalse(hasil.isEmpty());
		Kelas k = hasil.get(0);
		System.out.println("Jumlah peserta = "+k.getDaftarPeserta().size());
		
		Date mulai2 = frm.parse("2015-01-30");
		Date sampai2 = frm.parse("2015-02-10");
		List<Kelas> hasil2 = kelasDao.findByTanggalMulaiAntara(mulai2, sampai2);
		Assert.assertTrue(hasil2.isEmpty());
	}
	
	@Test
	public void testCariKelasByPeserta(){
		// peserta tidak ikut kelas sama sekali
		Peserta p0 = pesertaDao.findOne(98);
		List<Kelas> hasil0 = kelasDao.findByPeserta(p0);
		Assert.assertTrue(hasil0.isEmpty());
		
		// peserta yang ikut 1 kelas
		Peserta p1 = pesertaDao.findOne(91);
		List<Kelas> hasil1 = kelasDao.findByPeserta(p1);
		Assert.assertFalse(hasil1.isEmpty());
		Assert.assertTrue(hasil1.size() == 1);
		
		// peserta yang ikut 2 kelas
		Peserta p2 = pesertaDao.findOne(94);
		List<Kelas> hasil2 = kelasDao.findByPeserta(p2);
		Assert.assertFalse(hasil2.isEmpty());
		Assert.assertTrue(hasil2.size() == 2);
		
	}
}
