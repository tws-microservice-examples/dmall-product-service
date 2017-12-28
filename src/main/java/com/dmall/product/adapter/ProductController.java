package com.dmall.product.adapter;

import com.dmall.product.adapter.application.ProductApp;
import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForInventory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/products/")
public class ProductController {

  public ProductController() throws ParseException {

  }

  @RequestMapping(value = "inventory/{sku}", method = RequestMethod.GET)
  public ProductForInventory getProductForInventoryBySku(@PathVariable("sku") String sku) {
    ProductRepo repo = new ProductRepo();
    Product product = repo.getProductBySku(sku);

    ProductApp app = new ProductApp();
    return app.convertProductForInventory(product);
  }

}
