package com.example.loginpractice.service;

import com.example.loginpractice.model.Product;
import com.example.loginpractice.model.ProductDtoPost;
import com.example.loginpractice.model.ProductDtoRes;
import com.example.loginpractice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductDtoPost productDtoPost) {
        productRepository.save(Product.builder()
                        .name(productDtoPost.getName())
                        .price(productDtoPost.getPrice())
                        .build());
    }

    public ProductDtoRes findProductById(Integer id) {
        Optional<Product> result = productRepository.findById(id);
        if (result.isPresent()) {
            Product product = result.get();

            return ProductDtoRes.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .price(product.getPrice())
                    .build();
        } else {
            return null;
        }
    }

    public List<ProductDtoRes> findProductList() {
        List<Product> result = productRepository.findAll();
        List<ProductDtoRes> productDtoResList = new ArrayList<>();

        if (!result.isEmpty()) {
            for (Product product : result) {
                ProductDtoRes productDtoRes = ProductDtoRes.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build();
                productDtoResList.add(productDtoRes);
            }
            return productDtoResList;
        } else {
            return null;
        }
    }

    public void updateProduct(ProductDtoPost productDtoPost) {
        Optional<Product> result = productRepository.findById(productDtoPost.getId());
        if (result.isPresent()) {
            Product product = result.get();
            product.setName(productDtoPost.getName());
            product.setPrice(productDtoPost.getPrice());
            productRepository.save(product);
        }
    }

    public void deleteProduct(Integer id) {
        productRepository.delete(Product.builder().id(id).build());
    }
}
