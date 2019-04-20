package co.com.test.frameworks.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;

import co.com.test.frameworks.mongo.PersistenceMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersistenceMongoImpl<T> implements PersistenceMongo<T> {

	@Autowired
	private ReactiveMongoTemplate templateManager;

	@Override
	public Flux<T> listObject(Query query, Class<T> clazz) {
		return templateManager.find(query, clazz);
	}

	@Override
	public Mono<T> findObject(Object id, Class<T> clazz) {
		return templateManager.findById(id, clazz);
	}

	@Override
	public Mono<T> findObject(Query query, Class<T> clazz) {
		return templateManager.findOne(query, clazz);
	}

	@Override
	public Mono<T> saveOrUpdate(Mono<T> model) {
		
		return templateManager.save(model);
	}

	@Override
	public Mono<DeleteResult> remove(Query query, Class<T> clazz) {
		return templateManager.remove(query, clazz);
	}

	@Override
	public Flux<T> listObjectAll(Class<T> clazz) {
		return templateManager.findAll(clazz);
	}

}
