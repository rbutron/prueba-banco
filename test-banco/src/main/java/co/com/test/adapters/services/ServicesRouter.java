package co.com.test.adapters.services;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapters.handlers.AsesorHandler;
import co.com.test.adapters.handlers.MovimientoHandler;
import co.com.test.adapters.handlers.TarjetaHandler;
import co.com.test.adapters.handlers.UserHandler;

public interface ServicesRouter {
	
	RouterFunction<ServerResponse> routeUser(UserHandler handler);
	
	RouterFunction<ServerResponse> routeAsesor(AsesorHandler handler);
	
	RouterFunction<ServerResponse> routeTarjeta(TarjetaHandler handler);
	
	RouterFunction<ServerResponse> routeMovimiento(MovimientoHandler handler);
}
