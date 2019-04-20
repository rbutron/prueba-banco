package co.com.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import co.com.test.domains.models.UserModel;
import co.com.test.frameworks.utils.Constants;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WebClientTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void consultUSer() {
		webTestClient.get().uri(Constants.USERCONSULT).accept(MediaType.APPLICATION_JSON_UTF8).exchange().expectStatus()
				.isOk();

	}

}
