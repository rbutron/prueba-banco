package co.com.test.domains.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -930305961415049237L;
	
	private String mensaje;

}
