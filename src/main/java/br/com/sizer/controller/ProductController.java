package br.com.sizer.controller;

import br.com.sizer.utill.ProductSpecificationsBuilder;
import br.com.sizer.model.Product;
import br.com.sizer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    // -------------------create product -------------------
    @PostMapping("/product")
    ResponseEntity<?> createProduct(@RequestBody Product request) {
        Product response = productService.createProduct(request);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // -------read the company in json format with pagination----------
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = { "application/json" })
    ResponseEntity<?> getAllProduct(@RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "limit", defaultValue = "5") int limit) {
        Page<Product> response = productService.getAllProduct(page, limit);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // --------------------update the product --------------------
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT, consumes = { "application/json" }, produces = {
            "application/json" })
    public ResponseEntity<?> updateProduct(@PathVariable(value = "id") Long productId,
            @RequestBody Product productDetails) {
        Product response = productService.updateProduct(productId, productDetails);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    // ---------------------delete the product ---------------------
    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }

    // ------------------------search product ------------------------
    @RequestMapping(method = RequestMethod.GET, value = "/product")
    public ResponseEntity<?> search(@RequestParam(value = "search") String search) {
        ProductSpecificationsBuilder builder = new ProductSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Product> spec = builder.build();
        List<Product> response = productService.searchProduct(spec);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
