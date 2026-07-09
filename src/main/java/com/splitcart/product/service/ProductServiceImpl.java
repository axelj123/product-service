
package com.splitcart.product.service;

import com.splitcart.product.api.model.Availability;
import com.splitcart.product.api.model.Product;
import com.splitcart.product.mapper.ProductMapper;
import com.splitcart.product.repo.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
    implementar los metodos list, getById y availability usando el repositorio ProductRepository
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Flux<Product> list(String category, BigDecimal maxPrice, int page, int size) {
        return productRepository.findAll()
                .filter(product ->
                        category == null ||
                                category.isBlank() ||
                                category.equalsIgnoreCase(product.getCategory()))
                .filter(product ->
                        maxPrice == null ||
                                product.getPrice().compareTo(maxPrice) <= 0)
                .skip((long) page * size)
                .take(size)
                .map(ProductMapper::toDto);
    }

    @Override
    public Mono<Product> getById(String id) {
        return productRepository.findById(id).map(ProductMapper::toDto).switchIfEmpty(Mono.error(new NoSuchElementException("No existe id: " + id)));
    }

    @Override
    public Flux<Availability> availability(List<String> skus) {

        return Flux.fromIterable(skus)
                .flatMap(sku ->
                        productRepository.findById(sku).map(product -> new Availability().sku(product.getId()).available(10))
                                .defaultIfEmpty(new Availability().sku(sku).available(0))
                );
    }
}
