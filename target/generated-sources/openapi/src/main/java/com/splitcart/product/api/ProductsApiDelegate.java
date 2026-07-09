package com.splitcart.product.api;

import com.splitcart.product.api.model.Availability;
import java.math.BigDecimal;
import com.splitcart.product.api.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

/**
 * A delegate to be called by the {@link ProductsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-01-19T15:31:02.757931600-05:00[America/Lima]", comments = "Generator version: 7.7.0")
public interface ProductsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /api/products/availability : Disponibilidad de múltiples SKUs
     *
     * @param ids Lista de SKUs separados por coma (required)
     * @return Disponibilidad por SKU (status code 200)
     * @see ProductsApi#getAvailability
     */
    default Mono<ResponseEntity<Flux<Availability>>> getAvailability(String ids,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"available\" : 0, \"sku\" : \"sku\" }, { \"available\" : 0, \"sku\" : \"sku\" } ]";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /api/products/{id} : Obtener producto por ID/SKU
     *
     * @param id  (required)
     * @return Producto encontrado (status code 200)
     *         or Producto no encontrado (status code 404)
     * @see ProductsApi#getProductById
     */
    default Mono<ResponseEntity<Product>> getProductById(String id,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"price\" : 0.8008281904610115, \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * GET /api/products : Listado de productos con filtros y paginación
     *
     * @param category  (optional)
     * @param maxPrice  (optional)
     * @param page  (optional, default to 0)
     * @param size  (optional, default to 10)
     * @return Lista de productos (status code 200)
     * @see ProductsApi#listProducts
     */
    default Mono<ResponseEntity<Flux<Product>>> listProducts(String category,
        BigDecimal maxPrice,
        Integer page,
        Integer size,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "[ { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\" }, { \"price\" : 0.8008281904610115, \"name\" : \"name\", \"id\" : \"id\", \"category\" : \"category\" } ]";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
