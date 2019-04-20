package co.com.test.adapters.controllers;

import co.com.test.domains.models.AsesorModel;
import co.com.test.domains.models.StatusModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AsesorController {

	Mono<StatusModel> createAsesor(Mono<AsesorModel> m);

	Mono<Long> deleteAsesor(Mono<String> m);

	Flux<AsesorModel> consultAsesor();

	Mono<StatusModel> updateAsesor(Mono<AsesorModel> m);

}
