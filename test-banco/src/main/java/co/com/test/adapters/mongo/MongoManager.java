package co.com.test.adapters.mongo;

import org.springframework.data.mongodb.core.query.Query;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoManager<T> {
	
	Flux<T> listObject(Query query, Class<T> clazz);

	Mono<T> findObject(Object id, Class<T> clazz);

	Mono<T> findObject(Query query, Class<T> clazz);

	Mono<T> saveOrUpdate(Mono<T> model);
	
	Mono<Long> remove(Query query, Class<T> clazz);
	
	Flux<T> listObjectAll(Class<T> clazz);

}
