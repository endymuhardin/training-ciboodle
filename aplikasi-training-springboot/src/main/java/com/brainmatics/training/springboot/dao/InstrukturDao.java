package com.brainmatics.training.springboot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.brainmatics.training.springboot.entity.Instruktur;

public interface InstrukturDao extends PagingAndSortingRepository<Instruktur, Integer> {

}
