package com.brainmatics.training.springboot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.brainmatics.training.springboot.entity.Kelas;

public interface KelasDao extends PagingAndSortingRepository<Kelas, Integer> {

}
