package com.dmall.product.adapter;

import com.dmall.product.adapter.application.ProductApp;
import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForInventory;
import com.dmall.product.adapter.application.domain.ProductForOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductApp productApp;

  public ProductController() throws ParseException {

  }

  @RequestMapping(value = "/inventory/{sku}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductForInventory getProductForInventoryBySku(@PathVariable("sku") String sku) {
    Product product = productRepository.findBySku(sku);

    return productApp.convertProductForInventory(product);
  }

  @RequestMapping(value = "/order/{sku}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductForOrder getProductForOrderBySku(@PathVariable("sku") String sku) {
    Product product = productRepository.findBySku(sku);

    return productApp.convertProductForOrder(product);
  }

  @RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    Product savedProduct = productRepository.save(product);
    return savedProduct;
  }

}
