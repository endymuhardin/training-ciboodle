package com.brainmatics.training.springboot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.brainmatics.training.springboot.entity.Kelas;

public interface KelasDao extends PagingAndSortingRepository<Kelas, Integer> {

	public List<Kelas> findByInstrukturNamaContaining(String nama);

	@Query("select k from Kelas k where k.tanggalMulai >= :mulai and k.tanggalMulai <= :sampai order by k.tanggalMulai")
	public List<Kelas> findByTanggalMulaiAntara(@Param("mulai") Date mulai, @Param("sampai") Date sampai);

}
