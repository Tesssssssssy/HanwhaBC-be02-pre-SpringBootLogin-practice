package com.example.loginpractice.controller;

import com.example.loginpractice.model.ProductDtoPost;
import com.example.loginpractice.model.ProductDtoRes;
import com.example.loginpractice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createProduct(ProductDtoPost productDtoPost) {
        productService.createProduct(productDtoPost);
        return ResponseEntity.ok().body("Product 생성 완료");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity findProductById(Integer id) {
        ProductDtoRes productDtoRes = productService.findProductById(id);
        return ResponseEntity.ok().body(productDtoRes);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity findProductList() {
        List<ProductDtoRes> productDtoResList = productService.findProductList();
        return ResponseEntity.ok().body(productDtoResList);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateProduct(ProductDtoPost productDtoPost) {
        productService.updateProduct(productDtoPost);
        return ResponseEntity.ok().body("Product 수정 완료");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteProduct(Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product 삭제 완료");
    }
}
