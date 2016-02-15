package com.brainmatics.training.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.brainmatics.training.entity.Peserta;

@Repository
public class PesertaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void simpan(Peserta p){
		em.persist(p);
		
	}
}
