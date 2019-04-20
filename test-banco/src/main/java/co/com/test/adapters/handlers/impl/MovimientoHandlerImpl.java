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

import co.com.test.adapters.controllers.MovimientoController;
import co.com.test.adapters.handlers.MovimientoHandler;
import co.com.test.domains.models.MovimientoModel;
import co.com.test.domains.models.StatusModel;
import co.com.test.frameworks.utils.Constants;
import reactor.core.publisher.Mono;

@Service
public class MovimientoHandlerImpl implements MovimientoHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovimientoHandlerImpl.class);

	@Autowired
	private MovimientoController movimientoController;

	@Override
	public Mono<ServerResponse> createMovimiento(ServerRequest request) {
		return movimientoController.createMovimiento(request.bodyToMono(MovimientoModel.class)).defaultIfEmpty(new StatusModel())
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
	public Mono<ServerResponse> updateMovimiento(ServerRequest request) {
		return movimientoController.updateMovimiento(request.bodyToMono(MovimientoModel.class)).defaultIfEmpty(new StatusModel())
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
	public Mono<ServerResponse> deleteMovimiento(ServerRequest request) {
		return movimientoController.deleteMovimiento(Mono.just(request.pathVariable(Constants.ID))).flatMap(
				m -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(BodyInserters.fromObject(m)))
				.onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

	@Override
	public Mono<ServerResponse> consultMovimiento(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(movimientoController.consultMovimiento(), MovimientoModel.class).onErrorResume(e -> {
					LOGGER.error(e.getMessage(), e);
					return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
							.body(BodyInserters.fromObject(new StatusModel(e.getMessage())));
				});
	}

}
