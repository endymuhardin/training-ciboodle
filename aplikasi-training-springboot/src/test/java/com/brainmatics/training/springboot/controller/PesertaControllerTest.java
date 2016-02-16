package com.brainmatics.training.springboot.controller;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brainmatics.training.springboot.AplikasiTrainingSpringbootApplication;
import com.brainmatics.training.springboot.entity.Peserta;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AplikasiTrainingSpringbootApplication.class)
@Sql(scripts={"/delete-sample-data.sql","/sample-peserta.sql"})
@WebIntegrationTest(randomPort = true)
public class PesertaControllerTest {
	@Value("${local.server.port}")
    int serverPort;
	
	@Before
	public void setup(){
		RestAssured.port = serverPort;
	}
	
	@Test
	public void testListPeserta(){
		get("/peserta/")
		.then()
		.body("totalElements", equalTo(9))
		.body("content.id", hasItems(91, 92));
	}
	
	@Test
	public void testSimpanPesertaBaru(){
		Peserta p = new Peserta();
		p.setKode("PT-001");
		p.setNama("Peserta Test 001");
		p.setTanggalLahir(new Date());
		
		given()
			.body(p)
			.contentType(ContentType.JSON)
		.when()
			.post("/peserta/")
		.then()
			.statusCode(201);
	}
}
