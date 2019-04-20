package co.com.test.adapters.controllers;

import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.UserModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserController {

	Mono<StatusModel> createUser(Mono<UserModel> m);

	Mono<Long> deleteUser(Mono<String> m);

	Flux<UserModel> consultUser();

	Mono<StatusModel> updateUser(Mono<UserModel> m);

}
