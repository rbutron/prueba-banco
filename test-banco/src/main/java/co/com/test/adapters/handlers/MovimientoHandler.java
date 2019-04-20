package co.com.test.adapters.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface MovimientoHandler {
	
	Mono<ServerResponse> createMovimiento(ServerRequest request);

	Mono<ServerResponse> updateMovimiento(ServerRequest request);

	Mono<ServerResponse> deleteMovimiento(ServerRequest request);

	Mono<ServerResponse> consultMovimiento(ServerRequest request);

}
