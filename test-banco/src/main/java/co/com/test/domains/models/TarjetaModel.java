package co.com.test.domains.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TarjetaModel {
	private String id;
	private String idUsuario;
	private Long numTarjeta;
	private Short ccv;
	private String tipoTarjeta;
}
