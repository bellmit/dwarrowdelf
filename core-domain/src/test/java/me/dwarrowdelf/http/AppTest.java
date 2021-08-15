package me.dwarrowdelf.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.util.Properties;

public class AppTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

	@Test
	@Tag("Unit")
	@DisplayName("Should answer with true")
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	@Tag("Unit")
	@DisplayName("Should read application.properties file")
	public void shouldReadPropertiesFile() throws Exception {

		String root = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		LOGGER.info("Root path: {}", root);

		String configPath = root + "application.properties";
		Properties properties = new Properties();
		properties.load(new FileInputStream(configPath));

		String greeting = properties.getProperty("greeting");
		assertEquals("hello-motto", greeting);

	}

}
