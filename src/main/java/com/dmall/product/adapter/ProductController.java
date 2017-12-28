package com.dmall.product.adapter;

import com.dmall.product.adapter.application.ProductApp;
import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForInventory;
import com.dmall.product.adapter.application.domain.ProductForOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/products/")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductApp productApp;

  public ProductController() throws ParseException {

  }

  @RequestMapping(value = "inventory/{sku}", method = RequestMethod.GET)
  public ProductForInventory getProductForInventoryBySku(@PathVariable("sku") String sku) {
    Product product = productRepository.findBySku(sku);

    return productApp.convertProductForInventory(product);
  }

  @RequestMapping(value = "order/{sku}", method = RequestMethod.GET)
  public ProductForOrder getProductForOrderBySku(@PathVariable("sku") String sku) {
    Product product = productRepository.findBySku(sku);

    return productApp.convertProductForOrder(product);
  }

}
