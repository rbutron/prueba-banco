package co.com.test.adapters.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface UserHandler {

	Mono<ServerResponse> createUser(ServerRequest request);

	Mono<ServerResponse> updateUser(ServerRequest request);

	Mono<ServerResponse> deleteUser(ServerRequest request);

	Mono<ServerResponse> consultUser(ServerRequest request);

}
