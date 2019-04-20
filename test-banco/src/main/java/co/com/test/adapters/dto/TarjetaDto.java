package co.com.test.adapters.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.test.domains.models.TarjetaModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "tarjeta")
public class TarjetaDto extends TarjetaModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1483416393984636419L;
	
	@Id
	private String id;

}
