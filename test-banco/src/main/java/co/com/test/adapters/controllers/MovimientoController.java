package co.com.test.adapters.controllers;

import co.com.test.domains.models.MovimientoModel;
import co.com.test.domains.models.StatusModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovimientoController {
	
	Mono<StatusModel> createMovimiento(Mono<MovimientoModel> m);

	Mono<Long> deleteMovimiento(Mono<String> m);

	Flux<MovimientoModel> consultMovimiento();

	Mono<StatusModel> updateMovimiento(Mono<MovimientoModel> m);

}
