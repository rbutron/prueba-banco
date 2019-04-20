package co.com.test.adapters.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.test.adapters.controllers.UserController;
import co.com.test.adapters.reactive.user.UserReactive;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserControllerImpl implements UserController {
	
	@Autowired
	private UserReactive userReactive;

	@Override
	public Mono<StatusModel> createUser(Mono<UserModel> m) {
		return userReactive.createUser(m);
	}

	@Override
	public Mono<Long> deleteUser(Mono<String> m) {
		return userReactive.deleteUser(m);
	}

	@Override
	public Flux<UserModel> consultUser() {
		return userReactive.consultUser();
	}

	@Override
	public Mono<StatusModel> updateUser(Mono<UserModel> m) {
		return userReactive.updateUser(m);
	}
}
