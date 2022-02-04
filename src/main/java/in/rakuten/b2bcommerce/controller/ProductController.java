package in.rakuten.b2bcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.rakuten.b2bcommerce.dto.ProductDetail;
import in.rakuten.b2bcommerce.model.Product;
import in.rakuten.b2bcommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@ApiOperation(value = "/api/v1/product", tags = "Product Controller")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/create-product")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Integer createProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product.getId();
	}

	@GetMapping("/all-products/{user_id}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public List<ProductDetail> getAllProduct(@PathVariable("user_id") Integer userId) {
		return productService.getAllProducts(userId);
	}
	
	@GetMapping("/product/{productId}")
	@PreAuthorize("hasRole('ROLE_BUSINESS')")
	public Product getProductById(@PathVariable("productId") int productId) {
		return productService.getProductById(productId);
	}
	
	@DeleteMapping("/product/{productId}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProductById(productId);
	}
	
	@PutMapping("/product")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Product updateProduct(@RequestBody Product product) {
		productService.saveOrUpdate(product);
		return product;
	}
	
	
}
