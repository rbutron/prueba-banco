package co.com.test.adapters.controllers.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.test.adapters.controllers.AsesorController;
import co.com.test.adapters.reactive.asesor.AsesorReactive;
import co.com.test.domains.models.AsesorModel;
import co.com.test.domains.models.StatusModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class AsesorControllerImpl implements AsesorController {

	@Autowired
	private AsesorReactive asesorReactive;
	
	@Override
	public Mono<StatusModel> createAsesor(Mono<AsesorModel> m) {
		return asesorReactive.createAsesor(m);
	}

	@Override
	public Mono<Long> deleteAsesor(Mono<String> m) {
		return asesorReactive.deleteAsesor(m);
	}

	@Override
	public Flux<AsesorModel> consultAsesor() {
		return asesorReactive.consultAsesor();
	}

	@Override
	public Mono<StatusModel> updateAsesor(Mono<AsesorModel> m) {
		return asesorReactive.updateAsesor(m);
	}

}
