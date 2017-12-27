package com.dmall.product.adapter;

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
  public ProductForInventory getProductBySku(@PathVariable("sku") String sku) {
    return new ProductForInventory("The Bible for eCommerce Product Managers", "Paperback");
  }

}
