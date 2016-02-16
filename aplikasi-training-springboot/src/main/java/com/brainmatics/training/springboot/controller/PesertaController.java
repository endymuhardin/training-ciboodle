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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import com.brainmatics.training.springboot.dao.PesertaDao;
import com.brainmatics.training.springboot.entity.Peserta;
import com.brainmatics.training.springboot.exception.DataNotFoundException;

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
	
	@RequestMapping(value="/peserta/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Peserta cariById(@PathVariable("id") Peserta p){
		if(p == null){
			throw new DataNotFoundException("No data with the specified id");
		}
		return p;
	}
	
	@RequestMapping(value="/peserta/{id}", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updatePeserta(@PathVariable("id") Integer id, 
			@RequestBody @Valid Peserta p){
		Peserta px = pesertaDao.findOne(id);
		if(px == null){
			throw new DataNotFoundException("No data with the specified id");
		}
		p.setId(id);
		pesertaDao.save(p);
	}
	
	@RequestMapping(value="/peserta/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePeserta(@PathVariable("id") Integer id){
		if(!pesertaDao.exists(id)){
			throw new DataNotFoundException("No data with the specified id");
		}
		pesertaDao.delete(id);
	}
	
}
