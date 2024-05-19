package br.com.sizer.service;

import br.com.sizer.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Page<Product> getAllProduct(int page, int limit);

    Product updateProduct(Long id, Product productDetails);

    void deleteProduct(Long id);

    List<Product> searchProduct(Specification<Product> spec);
}
