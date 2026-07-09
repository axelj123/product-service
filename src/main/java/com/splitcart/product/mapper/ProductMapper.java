package com.splitcart.product.mapper;

import com.splitcart.product.api.model.Product;

public class ProductMapper {

    public ProductMapper() {
    }

    public static Product toDto(com.splitcart.product.model.Product product) {
        return new Product().id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice());

    }

}
