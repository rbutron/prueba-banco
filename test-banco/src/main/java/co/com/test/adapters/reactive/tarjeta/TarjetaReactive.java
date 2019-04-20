package co.com.test.adapters.reactive.tarjeta;

import co.com.test.domains.models.StatusModel;
import co.com.test.domains.models.TarjetaModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TarjetaReactive {

	Mono<StatusModel> createTarjeta(Mono<TarjetaModel> m);

	Mono<Long> deleteTarjeta(Mono<String> m);

	Flux<TarjetaModel> consultTarjeta();

	Mono<StatusModel> updateTarjeta(Mono<TarjetaModel> m);

}
