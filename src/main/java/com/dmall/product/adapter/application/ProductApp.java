package com.dmall.product.adapter.application;

import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForClient;
import org.springframework.stereotype.Component;

@Component
public class ProductApp {
    public ProductForClient convertProductForClients(Product product) {
        return product.convertProductForClient(product);
    }
}
