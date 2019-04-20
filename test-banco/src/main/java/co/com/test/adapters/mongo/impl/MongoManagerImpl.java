package co.com.test.adapters.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.DeleteResult;

import co.com.test.adapters.mongo.MongoManager;
import co.com.test.frameworks.mongo.PersistenceMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MongoManagerImpl<T> implements MongoManager<T> {

	@Autowired
	private PersistenceMongo<T> persistenceMongo;

	@Override
	public Flux<T> listObject(Query query, Class<T> clazz) {
		return persistenceMongo.listObject(query, clazz);
	}

	@Override
	public Mono<T> findObject(Object id, Class<T> clazz) {
		return persistenceMongo.findObject(id, clazz);
	}

	@Override
	public Mono<T> findObject(Query query, Class<T> clazz) {
		return persistenceMongo.findObject(query, clazz);
	}

	@Override
	public Mono<T> saveOrUpdate(Mono<T> model) {
		return persistenceMongo.saveOrUpdate(model);
	}

	@Override
	public Mono<Long> remove(Query query, Class<T> clazz) {
		return persistenceMongo.remove(query, clazz).map(DeleteResult::getDeletedCount);
	}

	@Override
	public Flux<T> listObjectAll(Class<T> clazz) {
		return persistenceMongo.listObjectAll(clazz);
	}

}