package co.com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import co.com.test.frameworks.utils.Constants;

@SpringBootApplication
public class App {

	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String... args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner init(@Value(Constants.ENVAPP) String env) {
		return args -> LOGGER.info(env);
	}

}
