package co.com.test.adapters.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.test.adapters.controllers.MovimientoController;
import co.com.test.adapters.reactive.movimiento.MovimientoReactive;
import co.com.test.domains.models.MovimientoModel;
import co.com.test.domains.models.StatusModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MovimientoControllerImpl implements MovimientoController {

	@Autowired
	private MovimientoReactive movimientoReactive;

	@Override
	public Mono<StatusModel> createMovimiento(Mono<MovimientoModel> m) {
		return movimientoReactive.createMovimiento(m);
	}

	@Override
	public Mono<Long> deleteMovimiento(Mono<String> m) {
		return movimientoReactive.deleteMovimiento(m);
	}

	@Override
	public Flux<MovimientoModel> consultMovimiento() {
		return movimientoReactive.consultMovimiento();
	}

	@Override
	public Mono<StatusModel> updateMovimiento(Mono<MovimientoModel> m) {
		return movimientoReactive.updateMovimiento(m);
	}

}
