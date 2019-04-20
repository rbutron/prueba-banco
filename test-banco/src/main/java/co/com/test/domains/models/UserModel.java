package co.com.test.domains.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserModel {
	private String id;
	private String nombre;
	private String direccion;
	private String ciudad;
	private Long telefono;
}
