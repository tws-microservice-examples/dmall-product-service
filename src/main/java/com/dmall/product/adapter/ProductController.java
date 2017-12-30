package com.dmall.product.adapter;

import com.dmall.product.adapter.application.ProductApp;
import com.dmall.product.adapter.application.domain.Product;
import com.dmall.product.adapter.application.domain.ProductForClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  ProductApp productApp;

  public ProductController() throws ParseException {

  }

  @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
  public List<ProductForClient> findBySkus(@RequestParam("skus") String[] skus) {
    List<Product> products = productRepository.findBySkuIn(Arrays.asList(skus));

    List<ProductForClient> result = products.stream()
            .map(product -> productApp.convertProductForClients(product))
            .collect(Collectors.toList());
    return result;
  }

  @RequestMapping(value = "/{sku}", method = RequestMethod.GET, headers = "Accept=application/json")
  public ProductForClient getProductBySku(@PathVariable("sku") String sku) {
    Product product = productRepository.findBySku(sku);

    return productApp.convertProductForClients(product);
  }

  @RequestMapping(value = "", method = RequestMethod.POST, headers = "Accept=application/json")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    Product savedProduct = productRepository.save(product);
    return savedProduct;
  }


}
