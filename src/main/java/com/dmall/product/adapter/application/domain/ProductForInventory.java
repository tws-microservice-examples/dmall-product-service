package com.dmall.product.adapter.application.domain;

public class ProductForInventory {
    private final String sku;
    private final String title;
    private final String spec;

    public ProductForInventory(String sku, String title, String spec) {
        this.sku = sku;
        this.title = title;
        this.spec = spec;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public String getSpec() {
        return spec;
    }
}
