package co.com.test.adapters.reactive.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.com.test.adapters.dto.UserDto;
import co.com.test.adapters.dto.query.TestQuery;
import co.com.test.adapters.mongo.MongoManager;
import co.com.test.adapters.reactive.user.UserReactive;
import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.UserModel;
import co.com.test.domains.usescases.user.impl.UserUseCase;
import co.com.test.frameworks.utils.ConverterModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserReactiveImpl extends UserUseCase implements UserReactive {

	@Autowired
	private MongoManager<UserDto> manager;

	@Override
	public Mono<StatusModel> createUser(Mono<UserModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	@Override
	public Mono<Long> deleteUser(Mono<String> m) {
		return m.flatMap(u -> manager.remove(TestQuery.remove(u), UserDto.class).onErrorResume(Mono::error))
				.onErrorResume(Mono::error);
	}

	@Override
	public Flux<UserModel> consultUser() {
		return manager.listObjectAll(UserDto.class).onErrorResume(Mono::error).cast(UserModel.class);
	}

	@Override
	public Mono<StatusModel> updateUser(Mono<UserModel> m) {
		return createOrUpdate(m, manager).onErrorResume(Mono::error);
	}

	private Mono<StatusModel> createOrUpdate(Mono<UserModel> m, MongoManager<UserDto> manager) {
		return m.flatMap(u -> manager.saveOrUpdate(Mono.just(ConverterModel.convert(u, UserDto.class)))
				.onErrorResume(Mono::error).then().cast(StatusModel.class)).onErrorResume(Mono::error);
	}

}
