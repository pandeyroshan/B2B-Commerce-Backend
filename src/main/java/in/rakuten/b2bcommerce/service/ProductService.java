package in.rakuten.b2bcommerce.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rakuten.b2bcommerce.dto.ProductDetail;
import in.rakuten.b2bcommerce.model.CartProduct;
import in.rakuten.b2bcommerce.model.Product;
import in.rakuten.b2bcommerce.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CartProductService cartProductService;

	public void saveOrUpdate(Product product) {
		productRepository.save(product);
	}

	public List<ProductDetail> getAllProducts(Integer userId) {
		List<Product> allProducts = new ArrayList<Product>();
		List<Product> myProducts = new ArrayList<Product>();
		List<ProductDetail> allProductDetails = new ArrayList<ProductDetail>();

		productRepository.findAll().forEach(product -> allProducts.add(product));

		List<CartProduct> cartProductsByUserId = cartProductService.getCartProductByUserId(userId);

		cartProductsByUserId.forEach(cartProduct -> myProducts.add(cartProduct.getProduct()));

		for (Product product : allProducts) {
			if (myProducts.contains(product)) {
				allProductDetails.add(new ProductDetail(product.getId(), product.getName(), product.getPrice(),
						product.getInStockQuantity(), product.getImageLink(), product.getActive(), true));
			} else {
				allProductDetails.add(new ProductDetail(product.getId(), product.getName(), product.getPrice(),
						product.getInStockQuantity(), product.getImageLink(), product.getActive(), false));
			}
		}
		System.out.println(allProductDetails);
		return allProductDetails;
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

	public List<Product> getAllProductForAdmin() {
		List<Product> allProducts = this.productRepository.findAll();
		return allProducts;
	}
	
	@Transactional
	public void changeProductVisibility(Integer ProductId, Boolean status) {
		this.productRepository.changeProductVisibility(ProductId, status);
	}
}