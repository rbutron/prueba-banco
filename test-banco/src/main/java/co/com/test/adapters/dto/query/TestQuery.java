package co.com.test.adapters.dto.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.com.test.frameworks.utils.Constants;

public class TestQuery {
	
	public static Query remove(Object... id) {
		return Query.query(Criteria.where(Constants.ID).in(id));
	}
	
	private TestQuery () {}

}
