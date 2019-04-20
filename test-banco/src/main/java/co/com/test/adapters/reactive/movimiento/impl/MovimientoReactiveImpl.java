package co.com.test.adapters.reactive.movimiento.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.test.adapters.dto.MovimientoDto;
import co.com.test.adapters.dto.query.TestQuery;
import co.com.test.adapters.mongo.MongoManager;
import co.com.test.adapters.reactive.movimiento.MovimientoReactive;
import co.com.test.domains.models.MovimientoModel;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.usescases.movimiento.impl.MovimientoUseCase;
import co.com.test.frameworks.utils.ConverterModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MovimientoReactiveImpl extends MovimientoUseCase implements MovimientoReactive {

	@Autowired
	private MongoManager<MovimientoDto> manager;

	@Override
	public Mono<StatusModel> createMovimiento(Mono<MovimientoModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	@Override
	public Mono<Long> deleteMovimiento(Mono<String> m) {
		return m.flatMap(u -> manager.remove(TestQuery.remove(u), MovimientoDto.class).onErrorResume(Mono::error))
				.onErrorResume(Mono::error);
	}

	@Override
	public Flux<MovimientoModel> consultMovimiento() {
		return manager.listObjectAll(MovimientoDto.class).onErrorResume(Mono::error).cast(MovimientoModel.class);
	}

	@Override
	public Mono<StatusModel> updateMovimiento(Mono<MovimientoModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	private Mono<StatusModel> createOrUpdate(Mono<MovimientoModel> m, MongoManager<MovimientoDto> manager) {
		return m.flatMap(u -> manager.saveOrUpdate(Mono.just(ConverterModel.convert(u, MovimientoDto.class)))
				.onErrorResume(Mono::error).then().cast(StatusModel.class)).onErrorResume(Mono::error);
	}

}
