
package com.splitcart.product.repo;

/*
Completar el repository que consuma de mongoDb de manera reactiva los productos
 */

import com.splitcart.product.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository <Product,String>{


}
