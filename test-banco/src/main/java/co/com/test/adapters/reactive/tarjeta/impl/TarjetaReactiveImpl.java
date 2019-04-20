package co.com.test.adapters.reactive.tarjeta.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.test.adapters.dto.TarjetaDto;
import co.com.test.adapters.dto.query.TestQuery;
import co.com.test.adapters.mongo.MongoManager;
import co.com.test.adapters.reactive.tarjeta.TarjetaReactive;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.TarjetaModel;
import co.com.test.domains.usescases.tarjeta.impl.TarjetaUseCase;
import co.com.test.frameworks.utils.ConverterModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TarjetaReactiveImpl extends TarjetaUseCase implements TarjetaReactive {

	@Autowired
	private MongoManager<TarjetaDto> manager;

	@Override
	public Mono<StatusModel> createTarjeta(Mono<TarjetaModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	@Override
	public Mono<Long> deleteTarjeta(Mono<String> m) {
		return m.flatMap(u -> manager.remove(TestQuery.remove(u), TarjetaDto.class).onErrorResume(Mono::error))
				.onErrorResume(Mono::error);
	}

	@Override
	public Flux<TarjetaModel> consultTarjeta() {
		return manager.listObjectAll(TarjetaDto.class).onErrorResume(Mono::error).cast(TarjetaModel.class);
	}

	@Override
	public Mono<StatusModel> updateTarjeta(Mono<TarjetaModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}
	
	private Mono<StatusModel> createOrUpdate(Mono<TarjetaModel> m, MongoManager<TarjetaDto> manager) {
		return m.flatMap(u -> manager.saveOrUpdate(Mono.just(ConverterModel.convert(u, TarjetaDto.class)))
				.onErrorResume(Mono::error).then().cast(StatusModel.class)).onErrorResume(Mono::error);
	}

}