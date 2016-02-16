package com.brainmatics.training.springboot.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

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
	public ResponseEntity<Void> pesertaBaru(@RequestBody @Valid Peserta peserta, 
			UriComponentsBuilder uriBuilder){
		pesertaDao.save(peserta);
		URI location = uriBuilder.path("/peserta/{id}")
				.buildAndExpand(peserta.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
	}
}
