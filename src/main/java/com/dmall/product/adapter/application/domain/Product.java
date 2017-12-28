package com.dmall.product.adapter.application.domain;

public class Product {
    private final String sku;
    private final String title;
    private final String spec;
    private final String brand;

    public Product(String sku, String title, String spec, String brand) {
        this.sku = sku;
        this.title = title;
        this.spec = spec;
        this.brand = brand;
    }

    public ProductForInventory convertProductForInventory(Product product) {
        return new ProductForInventory(product.getSku(), product.getTitle(), product.getSpec());
    }

    private String getSku() {
        return this.sku;
    }

    private String getTitle() {
        return this.title;
    }

    public String getSpec() {
        return this.spec;
    }
}
