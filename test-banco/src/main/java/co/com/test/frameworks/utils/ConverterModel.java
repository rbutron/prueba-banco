package co.com.test.frameworks.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterModel {

	public static <T, R> T convert(R r, Class<T> clazz) {
		ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return om.convertValue(r, clazz);
	}

	private ConverterModel() {

	}

}
