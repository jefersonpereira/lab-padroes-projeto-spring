package br.com.sizer.service;

import br.com.sizer.exception.ResourceNotFoundException;
import br.com.sizer.model.Product;
import br.com.sizer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProduct(int page, int limit) {
        Page<Product> resultPage = productRepository.findAll(new PageRequest(page, limit));
        if (page > resultPage.getTotalPages())
            throw new ResourceNotFoundException("Product", "id", resultPage);
        return resultPage;
    }

    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id);
        if (product == null)
            throw new ResourceNotFoundException("Product", "id", id);

        product.setName(productDetails.getName());
        product.setProductId(productDetails.getProductId());
        product.setSkuId(productDetails.getSkuId());
        product.setBust(productDetails.getBust());
        product.setWaist(productDetails.getWaist());
        product.setHip(productDetails.getHip());
        product.setLength(productDetails.getLength());
        product.setCreatedBy(productDetails.getCreatedBy());
        product.setStore(productDetails.getStore());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product == null)
            throw new ResourceNotFoundException("Product", "id", id);

        productRepository.delete(product);
    }

    @Override
    public List<Product> searchProduct(Specification<Product> spec) {
        return productRepository.findAll(spec);
    }
}
