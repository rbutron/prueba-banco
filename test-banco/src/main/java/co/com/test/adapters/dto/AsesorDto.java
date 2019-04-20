package co.com.test.adapters.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.test.domains.models.AsesorModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "asesor")
public class AsesorDto extends AsesorModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6360783448898772671L;
	
	@Id
	private String id;

}
