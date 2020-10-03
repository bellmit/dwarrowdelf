package com.bankless.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.datastax.oss.driver.shaded.guava.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({ "test" })
public class StatusControllerTests {

	@Value("${local.server.port}")
	private int serverPort;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	private ResponseEntity<String> getAccount(String countryCode, String accountNo) throws URISyntaxException {

		String url = "http://localhost:" + serverPort + "/{country}/account?no={accountNo}";

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);

		Map<String, String> params = ImmutableMap.of("country", countryCode, "accountNo", accountNo);

		return restTemplate.exchange(url, HttpMethod.GET, entity, String.class, params);

	}

	@Test
	@DisplayName("GET account should return status code 200")
	public void getAccount_Found() throws Exception {

		ResponseEntity<String> response = getAccount("CAN", "90001");
		assertEquals(HttpStatus.OK, response.getStatusCode());
		System.out.println(response.getBody());

	}

	@Test
	@DisplayName("GET account should return status code 200")
	public void getAccount_NotFound() throws Exception {

		ResponseEntity<String> response = getAccount("COL", "90123");
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		System.out.println(response.getBody());

	}

}