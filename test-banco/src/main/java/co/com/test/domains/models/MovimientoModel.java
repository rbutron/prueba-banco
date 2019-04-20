package co.com.test.domains.models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovimientoModel {
	private String id;
	private String idUsuario;
	private Date fechaConsumo;
	private String descripcion;
	private Double monto;
}
