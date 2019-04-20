package co.com.test.adapters.services.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapters.handlers.AsesorHandler;
import co.com.test.adapters.handlers.MovimientoHandler;
import co.com.test.adapters.handlers.TarjetaHandler;
import co.com.test.adapters.handlers.UserHandler;
import co.com.test.adapters.services.ServicesRouter;
import co.com.test.frameworks.utils.Constants;

@Configuration
@EnableWebFlux
public class ServicesRouterImpl implements ServicesRouter, WebFluxConfigurer {

	@Bean
	@Override
	public RouterFunction<ServerResponse> routeUser(UserHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.POST(Constants.USERCREATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::createUser)
				.andRoute(RequestPredicates.PUT(Constants.USERUPDATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateUser)
				.andRoute(RequestPredicates.DELETE(Constants.USERDELETE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteUser)
				.andRoute(RequestPredicates.GET(Constants.USERCONSULT)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::consultUser);
	}

	@Bean
	@Override
	public RouterFunction<ServerResponse> routeAsesor(AsesorHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.POST(Constants.ASESORCREATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::createAsesor)
				.andRoute(RequestPredicates.PUT(Constants.ASESORUPDATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateAsesor)
				.andRoute(RequestPredicates.DELETE(Constants.ASESORDELETE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteAsesor)
				.andRoute(RequestPredicates.GET(Constants.ASESORCONSULT)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::consultAsesor);
	}

	@Bean
	@Override
	public RouterFunction<ServerResponse> routeTarjeta(TarjetaHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.POST(Constants.TARJETACREATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::createTarjeta)
				.andRoute(RequestPredicates.PUT(Constants.TARJETAUPDATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateTarjeta)
				.andRoute(RequestPredicates.DELETE(Constants.TARJETADELETE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteTarjeta)
				.andRoute(RequestPredicates.GET(Constants.TARJETACONSULT)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::consultTarjeta);
	}

	@Bean
	@Override
	public RouterFunction<ServerResponse> routeMovimiento(MovimientoHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.POST(Constants.MOVIMIENTOCREATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::createMovimiento)
				.andRoute(RequestPredicates.PUT(Constants.MOVIMIENTOUPDATE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::updateMovimiento)
				.andRoute(RequestPredicates.DELETE(Constants.MOVIMIENTODELETE)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::deleteMovimiento)
				.andRoute(RequestPredicates.GET(Constants.MOVIMIENTOCONSULT)
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::consultMovimiento);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping(Constants.CONTEXTAPPALL).allowedHeaders(Constants.ASTERISK)
				.allowedMethods(Constants.ASTERISK).allowedOrigins(Constants.ASTERISK).allowCredentials(true);
	}

}
