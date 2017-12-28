package com.dmall.product.adapter.application;

import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForInventory;
import com.dmall.product.adapter.application.domain.ProductForOrder;
import org.springframework.stereotype.Component;

@Component
public class ProductApp {
    public ProductForInventory convertProductForInventory(Product product) {
        return product.convertProductForInventory(product);
    }

    public ProductForOrder convertProductForOrder(Product product) {
        return product.convertProductForOrder(product);
    }
}
