package com.dmall.product.adapter;

public class ProductForInventory {
    private final String name;
    private final String spec;

    public ProductForInventory(String name, String spec) {
        this.name = name;
        this.spec = spec;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return spec;
    }
}
