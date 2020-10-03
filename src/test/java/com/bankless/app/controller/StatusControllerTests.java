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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({ "test" })
public class StatusControllerTests {

	private TestRestTemplate restTemplate = new TestRestTemplate();

	private ResponseEntity<String> getAccount(String countryCode, String accountNo) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", "application/json");
		HttpEntity<?> entity = new HttpEntity<>(headers);

		Map<String, String> params = ImmutableMap.of("country", countryCode);
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("/{country}/account");
		builder.queryParam("no", accountNo);

		return restTemplate.exchange(builder.build(params), HttpMethod.GET, entity, String.class);

	}

	@Test
	public void contextLoads() {
	}

	@Test
	@DisplayName("GET status should be successful")
	public void getAccount() throws Exception {

		ResponseEntity<String> response = getAccount( "USA", "80001");

		assertEquals(HttpStatus.OK, response.getStatusCode());

	}

}