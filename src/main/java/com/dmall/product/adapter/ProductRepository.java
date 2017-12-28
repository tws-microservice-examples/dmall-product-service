package com.dmall.product.adapter;

import com.dmall.product.adapter.application.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Product findBySku(String sku);
}
