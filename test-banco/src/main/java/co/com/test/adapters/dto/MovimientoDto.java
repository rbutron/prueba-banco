package co.com.test.adapters.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.test.domains.models.MovimientoModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "movimiento")
public class MovimientoDto extends MovimientoModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7866706867918699634L;
	
	@Id
	private String id;

}
