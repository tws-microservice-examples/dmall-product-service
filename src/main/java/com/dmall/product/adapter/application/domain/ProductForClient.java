package com.dmall.product.adapter.application.domain;

public class ProductForClient {
    private final String sku;
    private final String title;
    private final String spec;
    private final String brand;
    private final String pic;
    private final Double price;

    public ProductForClient(String sku, String title, String spec, String brand, String pic, Double price) {
        this.sku = sku;
        this.title = title;
        this.spec = spec;
        this.brand = brand;
        this.pic = pic;
        this.price = price;
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

    public String getBrand() {
        return brand;
    }

    public String getPic() {
        return pic;
    }

    public Double getPrice() {
        return price;
    }
}
