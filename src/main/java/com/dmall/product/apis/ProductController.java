package com.dmall.product.apis;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

  public ProductController() throws ParseException {

  }

  @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
  public List<ProductForInventory> getAllProducsForInventory() {
    List<ProductForInventory> productsForInventory = Arrays.asList(
            new ProductForInventory("The Bible for eCommerce Product Managers", "Paperback"),
            new ProductForInventory("Spring Microservices in Action", "Hardcover")
    );
    return productsForInventory;
  }

  @RequestMapping(value = "{sku}", method = RequestMethod.GET)
  public ProductForInventory getProductBySku(@PathVariable("sku") String sku) {
    return new ProductForInventory("The Bible for eCommerce Product Managers", "Paperback");
  }

}
