package com.brainmatics.training.springboot.controller;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import java.text.SimpleDateFormat;
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
	public void testSimpanPesertaBaru() throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Peserta p = new Peserta();
		p.setKode("PT-001");
		p.setNama("Peserta Test 001");
		p.setTanggalLahir(formatter.parse("2010-10-10"));
		
		given()
			.body(p)
			.contentType(ContentType.JSON)
		.when()
			.post("/peserta/")
		.then()
			.statusCode(201)
			.header("Location", containsString("/peserta/"))
			.log().headers();
		
		// nama tidak diisi
		Peserta px = new Peserta();
		px.setKode("PT-001");
		given()
			.body(px)
			.contentType(ContentType.JSON)
		.when()
			.post("/peserta/")
		.then()
			.statusCode(400);
		
		// kode kurang dari 3 huruf
		Peserta px1 = new Peserta();
		px1.setKode("PT");
		px1.setNama("Peserta Test");
		p.setTanggalLahir(formatter.parse("2010-10-10"));
		
		given()
			.body(px1)
			.contentType(ContentType.JSON)
		.when()
			.post("/peserta/")
		.then()
			.statusCode(400);
		
		// tanggal lahir di masa depan
		Peserta px2 = new Peserta();
		px2.setKode("PT-009");
		px2.setNama("Peserta Test");
		p.setTanggalLahir(formatter.parse("3010-10-10"));
		given()
			.body(px1)
			.contentType(ContentType.JSON)
		.when()
			.post("/peserta/")
		.then()
			.statusCode(400);
	}
	
	@Test
	public void testCariById(){
		get("/peserta/99")
		.then()
			.statusCode(200)
			.body("id", equalTo(99))
			.body("kode", equalTo("P-009"));
		
		get("/peserta/990")
		.then()
			.statusCode(404);
	}
	
	@Test
	public void testUpdate(){
		Peserta p = new Peserta();
		p.setKode("PX-009");
		p.setNama("Peserta 909");
		p.setTanggalLahir(new Date());
		
		given()
			.body(p)
			.contentType(ContentType.JSON)
		.when()
			.put("/peserta/99")
		.then()
			.statusCode(200);
		
		get("/peserta/99")
		.then()
			.statusCode(200)
			.body("id", equalTo(99))
			.body("kode", equalTo("PX-009"))
			.body("nama", equalTo("Peserta 909"));
	}
	
	@Test
	public void testDelete(){
		delete("/peserta/99")
		.then()
		.statusCode(200);
		
		get("/peserta/99")
		.then()
			.statusCode(404);
	}
}
