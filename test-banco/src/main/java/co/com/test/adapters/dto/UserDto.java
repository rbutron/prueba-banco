package co.com.test.adapters.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.test.domains.models.UserModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Document(collection = "user")
public class UserDto extends UserModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4750908017251715898L;
	
	@Id
	private String id;

}
