package me.dwarrowdelf.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {

		LOGGER.info("Running the main method");
		if (args.length > 0) {
			LOGGER.info("List of arguments {}", Arrays.toString(args));
		}

	}

}
