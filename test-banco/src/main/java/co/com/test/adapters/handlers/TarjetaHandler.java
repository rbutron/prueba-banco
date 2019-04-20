package co.com.test.adapters.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface TarjetaHandler {
	
	Mono<ServerResponse> createTarjeta(ServerRequest request);

	Mono<ServerResponse> updateTarjeta(ServerRequest request);

	Mono<ServerResponse> deleteTarjeta(ServerRequest request);

	Mono<ServerResponse> consultTarjeta(ServerRequest request);

}
