package in.rakuten.b2bcommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.model.Product;
import in.rakuten.b2bcommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<Product>();
		productRepository.findAll().forEach(product -> allProducts.add(product));
		return allProducts;
	}
	
	public Product getProductById(int productId) {
		Product product = productRepository.getById(productId);
		return product;
	}
	
	public void deleteProductById(int productId) {
		productRepository.deleteById(productId);
	}
	
	public void updateProduct(Product product, int product_id) {
		productRepository.save(product);
	}
}