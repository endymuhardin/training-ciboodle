package com.brainmatics.training.springboot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.brainmatics.training.springboot.entity.Peserta;

public interface PesertaDao extends PagingAndSortingRepository<Peserta, Integer> {

}
