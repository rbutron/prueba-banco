package co.com.test.frameworks.mongo;

import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.client.result.DeleteResult;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersistenceMongo<T> {
	Flux<T> listObject(Query query, Class<T> clazz);
	
	Flux<T> listObjectAll(Class<T> clazz);

	Mono<T> findObject(Object id, Class<T> clazz);

	Mono<T> findObject(Query query, Class<T> clazz);

	Mono<T> saveOrUpdate(Mono<T> model);
	
	Mono<DeleteResult> remove(Query query, Class<T> clazz);
	
}
