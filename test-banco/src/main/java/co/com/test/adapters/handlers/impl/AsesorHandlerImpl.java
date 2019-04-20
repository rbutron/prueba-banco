package co.com.test.adapters.handlers.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapters.controllers.AsesorController;
import co.com.test.adapters.handlers.AsesorHandler;
import co.com.test.domains.models.AsesorModel;
import co.com.test.domains.models.StatusModel;
import co.com.test.frameworks.utils.Constants;
import reactor.core.publisher.Mono;

@Service
public class AsesorHandlerImpl implements AsesorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(AsesorHandlerImpl.class);

	@Autowired
	private AsesorController asesorController;

	@Override
	public Mono<ServerResponse> createAsesor(ServerRequest request) {
		return asesorController.createAsesor(request.bodyToMono(AsesorModel.class)).defaultIfEmpty(new StatusModel())
				.flatMap(m -> {
					Mono<ServerResponse> server;
					if (m.getMensaje() == null) {
						m.setMensaje(Constants.MSGSAVE);
						server = ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromObject(m));
					} else {
						server = ServerResponse.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromObject(m));
					}
					return server;
				}).onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

	@Override
	public Mono<ServerResponse> updateAsesor(ServerRequest request) {
		return asesorController.updateAsesor(request.bodyToMono(AsesorModel.class)).defaultIfEmpty(new StatusModel())
				.flatMap(m -> {
					Mono<ServerResponse> server;
					if (m.getMensaje() == null) {
						m.setMensaje(Constants.MSGSAVE);
						server = ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromObject(m));
					} else {
						server = ServerResponse.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromObject(m));
					}
					return server;
				}).onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

	@Override
	public Mono<ServerResponse> deleteAsesor(ServerRequest request) {
		return asesorController.deleteAsesor(Mono.just(request.pathVariable(Constants.ID))).flatMap(
				m -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(m)))
				.onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

	@Override
	public Mono<ServerResponse> consultAsesor(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(asesorController.consultAsesor(), AsesorModel.class).onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

}
