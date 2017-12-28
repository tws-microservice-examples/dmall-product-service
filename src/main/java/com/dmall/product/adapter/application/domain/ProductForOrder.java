package com.dmall.product.adapter.application.domain;

public class ProductForOrder {
    private final String sku;
    private final String title;
    private final String pic;
    private final Double price;

    public ProductForOrder(String sku, String title, String pic, Double price) {
        this.sku = sku;
        this.title = title;
        this.pic = pic;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public String getTitle() {
        return title;
    }

    public String getPic() {
        return pic;
    }

    public Double getPrice() {
        return price;
    }
}
