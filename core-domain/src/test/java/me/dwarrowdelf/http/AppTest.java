package me.dwarrowdelf.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

	@Test
	@Tag("Unit")
	@DisplayName("Core should read an application.properties file")
	public void shouldReadPropertiesFile() throws Exception {

		String root = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		LOGGER.info("Root path: {}", root);

		String configPath = root + "application.properties";
		Properties properties = new Properties();
		properties.load(new FileInputStream(configPath));

		String greeting = properties.getProperty("greeting");
		assertEquals("hello-motto", greeting);

	}

	@Test
	@Tag("Unit")
	@DisplayName("Core should read a .txt file")
	public void shouldReadTxtFile() throws Exception {

		String fileName = "sample.txt";

		Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
		List<String> lines = Files.lines(path).collect(Collectors.toList());

		LOGGER.info("Lines from {} file", fileName);
		lines.forEach(line -> LOGGER.info("> {}", line));

	}

}
