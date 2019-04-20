package co.com.test.adapters.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface AsesorHandler {

	Mono<ServerResponse> createAsesor(ServerRequest request);

	Mono<ServerResponse> updateAsesor(ServerRequest request);

	Mono<ServerResponse> deleteAsesor(ServerRequest request);

	Mono<ServerResponse> consultAsesor(ServerRequest request);

}
