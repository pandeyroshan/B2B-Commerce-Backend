package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.model.Product;
import in.rakuten.b2bcommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@ApiOperation(value = "/api/v1/product", tags = "Product Controller")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/create-product")
	public Integer createProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product.getId();
	}

	@GetMapping("/all-products")
	public List<Product> getAllProduct() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProductById(@PathVariable("productId") int productId) {
		return productService.getProductById(productId);
	}
	
	@DeleteMapping("/product/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProductById(productId);
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product;
	}
	
	
}
