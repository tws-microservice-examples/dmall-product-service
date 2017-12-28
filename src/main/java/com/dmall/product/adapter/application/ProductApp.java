package com.dmall.product.adapter.application;

import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForInventory;

public class ProductApp {
    public ProductForInventory convertProductForInventory(Product product) {
        return product.convertProductForInventory(product);
    }
}
