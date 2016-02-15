package com.brainmatics.training.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kelas {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
}
