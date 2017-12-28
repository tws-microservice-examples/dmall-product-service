package com.dmall.product.adapter.application.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;
    private String sku;
    private String title;
    private String spec;
    private String brand;

    public Product() {
    }

    public Product(String sku, String title, String spec, String brand) {
        this.sku = sku;
        this.title = title;
        this.spec = spec;
        this.brand = brand;
    }

    public ProductForInventory convertProductForInventory(Product product) {
        return new ProductForInventory(product.getSku(), product.getTitle(), product.getSpec());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
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
