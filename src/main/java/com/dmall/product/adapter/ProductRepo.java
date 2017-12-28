package com.dmall.product.adapter;

import com.dmall.product.adapter.application.domain.Product;

public class ProductRepo {
    public Product getProductBySku(String sku) {
        return new Product("6009901", "Apple - iPhone X 64GB - Space Gray (Verizon)", "64GB - Space Gray (Verizon)", "Apple");
    }
}
