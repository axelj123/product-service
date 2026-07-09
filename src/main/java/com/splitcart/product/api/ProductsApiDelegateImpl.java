
package com.splitcart.product.api;

import com.splitcart.product.api.model.Availability;
import com.splitcart.product.api.model.Product;
import com.splitcart.product.service.ProductService;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
  implementar los metodos listProducts, getProductById y getAvailability usando el servicio ProductService
 */
@Component
@RequiredArgsConstructor
public class ProductsApiDelegateImpl implements ProductsApiDelegate  {

  private final ProductService service;

  @Override
  public Mono<ResponseEntity<Flux<Product>>> listProducts(
      String category, BigDecimal maxPrice, Integer page, Integer size, ServerWebExchange exchange) {
    return Mono.just(
            ResponseEntity.ok(
                    service.list(
                            category,
                            maxPrice,
                            page == null ? 0 : page,
                            size == null ? 10 : size)));
  }

  @Override
  public Mono<ResponseEntity<Product>> getProductById(String id, ServerWebExchange exchange) {
    return service.getById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @Override
  public Mono<ResponseEntity<Flux<Availability>>> getAvailability(
          String ids,
          ServerWebExchange exchange) {

    return Mono.just(ids)
            .map(value -> Arrays.stream(value.split(","))
                    .map(String::trim)
                    .toList())
            .map(service::availability)
            .map(ResponseEntity::ok);
  }
}
