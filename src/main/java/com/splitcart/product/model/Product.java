
package com.splitcart.product.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


/*
Agregar las anotaciones necesarias para que esta clase sea un documento de MongoDB, uso de lombok para getters, setters y constructor sin argumentos
 */
@Getter
@Setter
@NoArgsConstructor
@Document(collection = "products")
public class Product {

  @Id private String id;
  private String name;
  private String category;
  private BigDecimal price;
}
