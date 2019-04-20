package co.com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.test.frameworks.mongo.impl.PersistenceMongoImpl;
import reactor.test.StepVerifier;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistenceMongoTest {
	
	@InjectMocks
	private PersistenceMongoImpl<Object> mongo;
	
	@Mock
	private ReactiveMongoTemplate templateManager;
	
	@Test
	public void saveObject() {
		StepVerifier.create(mongo.saveOrUpdate(Mockito.any())).expectError(NullPointerException.class);
	}
	
	@Test
	public void listObject() {
		StepVerifier.create(mongo.listObject(new Query(), Object.class)).expectError(NullPointerException.class);
	}
	
	@Test
	public void findObject() {
		StepVerifier.create(mongo.findObject(new Query(), Object.class)).expectError(NullPointerException.class);
	}
	
	@Test
	public void findObject1() {
		StepVerifier.create(mongo.findObject("", Object.class)).expectError(NullPointerException.class);
	}
	
	@Test
	public void remove() {
		StepVerifier.create(mongo.remove(new Query(), Object.class)).expectError(NullPointerException.class);
	}
	
	@Test
	public void listObjectAll() {
		StepVerifier.create(mongo.listObjectAll(Object.class)).expectError(NullPointerException.class);
	}

}
