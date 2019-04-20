package co.com.test.frameworks.utils;

public class Constants {
	
	public static final String ENVAPP = "${app.env}";
	private static final String CONTEXTAPP = "/test-banco/";
	public static final String CONTEXTAPPALL = CONTEXTAPP.concat("**");
	public static final String ASTERISK = "*";
	
	public static final String ID = "id";
	
	public static final String USERCREATE = CONTEXTAPP.concat("api/user/create");
	public static final String USERUPDATE = CONTEXTAPP.concat("api/user/update");
	public static final String USERDELETE = CONTEXTAPP.concat("api/user/delete/{id}");
	public static final String USERCONSULT = CONTEXTAPP.concat("api/user/consult");
	
	public static final String ASESORCREATE = CONTEXTAPP.concat("api/asesor/create");
	public static final String ASESORUPDATE = CONTEXTAPP.concat("api/asesor/update");
	public static final String ASESORDELETE = CONTEXTAPP.concat("api/asesor/delete/{id}");
	public static final String ASESORCONSULT = CONTEXTAPP.concat("api/asesor/consult");
	
	public static final String TARJETACREATE = CONTEXTAPP.concat("api/tarjeta/create");
	public static final String TARJETAUPDATE = CONTEXTAPP.concat("api/tarjeta/update");
	public static final String TARJETADELETE = CONTEXTAPP.concat("api/tarjeta/delete/{id}");
	public static final String TARJETACONSULT = CONTEXTAPP.concat("api/tarjeta/consult");
	
	public static final String MOVIMIENTOCREATE = CONTEXTAPP.concat("api/movimiento/create");
	public static final String MOVIMIENTOUPDATE = CONTEXTAPP.concat("api/movimiento/update");
	public static final String MOVIMIENTODELETE = CONTEXTAPP.concat("api/movimiento/delete/{id}");
	public static final String MOVIMIENTOCONSULT = CONTEXTAPP.concat("api/movimiento/consult");
	
	public static final String MSGSAVE = "Se registro correctamente";
	
	private Constants () {}

}
