package com.brainmatics.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.brainmatics.training.springboot.dao.PesertaDao;
import com.brainmatics.training.springboot.entity.Peserta;

@Controller
public class PesertaController {
	@Autowired private PesertaDao pesertaDao;
	
	@RequestMapping(value="/peserta/", method=RequestMethod.GET)
	@ResponseBody
	public Page<Peserta> semuaPeserta(Pageable page){
		return pesertaDao.findAll(page);
	}
	
	@RequestMapping(value="/peserta/", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void pesertaBaru(@RequestBody Peserta peserta){
		pesertaDao.save(peserta);
	}
}
