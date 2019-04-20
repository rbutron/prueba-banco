package co.com.test.adapters.reactive.asesor.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.test.adapters.dto.AsesorDto;
import co.com.test.adapters.dto.query.TestQuery;
import co.com.test.adapters.mongo.MongoManager;
import co.com.test.adapters.reactive.asesor.AsesorReactive;
import co.com.test.domains.models.AsesorModel;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.usescases.asesor.impl.AsesorUseCase;
import co.com.test.frameworks.utils.ConverterModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AsesorReactiveImpl extends AsesorUseCase implements AsesorReactive {

	@Autowired
	private MongoManager<AsesorDto> manager;

	@Override
	public Mono<StatusModel> createAsesor(Mono<AsesorModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	@Override
	public Mono<Long> deleteAsesor(Mono<String> m) {
		return m.flatMap(u -> manager.remove(TestQuery.remove(u), AsesorDto.class).onErrorResume(Mono::error))
				.onErrorResume(Mono::error);
	}

	@Override
	public Flux<AsesorModel> consultAsesor() {
		return manager.listObjectAll(AsesorDto.class).onErrorResume(Mono::error).cast(AsesorModel.class);
	}

	@Override
	public Mono<StatusModel> updateAsesor(Mono<AsesorModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	private Mono<StatusModel> createOrUpdate(Mono<AsesorModel> m, MongoManager<AsesorDto> manager) {
		return m.flatMap(u -> manager.saveOrUpdate(Mono.just(ConverterModel.convert(u, AsesorDto.class)))
				.onErrorResume(Mono::error).then().cast(StatusModel.class)).onErrorResume(Mono::error);
	}

}
