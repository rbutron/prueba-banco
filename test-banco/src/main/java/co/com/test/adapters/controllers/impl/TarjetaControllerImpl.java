package co.com.test.adapters.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.test.adapters.controllers.TarjetaController;
import co.com.test.adapters.reactive.tarjeta.TarjetaReactive;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.TarjetaModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class TarjetaControllerImpl implements TarjetaController {
	
	@Autowired
	private TarjetaReactive tarjetaReactive;

	@Override
	public Mono<StatusModel> createTarjeta(Mono<TarjetaModel> m) {
		return tarjetaReactive.createTarjeta(m);
	}

	@Override
	public Mono<Long> deleteTarjeta(Mono<String> m) {
		return tarjetaReactive.deleteTarjeta(m);
	}

	@Override
	public Flux<TarjetaModel> consultTarjeta() {
		return tarjetaReactive.consultTarjeta();
	}

	@Override
	public Mono<StatusModel> updateTarjeta(Mono<TarjetaModel> m) {
		return tarjetaReactive.updateTarjeta(m);
	}

}
