package com.brainmatics.training.springboot.controller;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.brainmatics.training.springboot.AplikasiTrainingSpringbootApplication;
import com.jayway.restassured.RestAssured;

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
}
