package com.dmall.product.apis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.dmall.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	private List<Product> products = null;

	public ProductController() throws ParseException {
		this.products = Arrays.asList(
				new Product("p001", "Iphone 6s"+ "-" + getHostIP(), formatter.parse("2015-04-23")),
				new Product("p002", "Xiaomi"+ "-" + getHostIP(), formatter.parse("2015-05-12")),
				new Product("p003", "Oppo R11"+ "-" + getHostIP(), formatter.parse("2015-04-27")));
	}

	@GetMapping
	public List<Product> getCommentsByTaskId() {

		return products;
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Product getProductbyId(@PathVariable("productId") final String productId) {
		Optional<Product> product = products.stream().filter(c -> Objects.equals(c.getProductId(), productId)).findAny();

		 return product.isPresent() ? product.get() : null;	
	}

	private String getHostIP() {
		InetAddress ip;
		try {
  
		  ip = InetAddress.getLocalHost();
		  return ip.getHostAddress();
  
		} catch (UnknownHostException e) {
  
		  return "Ip Empty";
  
		}
  
	}
}
