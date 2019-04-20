package co.com.test;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.test.frameworks.utils.ConverterModel;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ConverterModelTest {
	
	@Test
	public void converterModel() {
		String a = ConverterModel.convert(1, String.class);
		assertNotEquals(1, a);
	}

}
