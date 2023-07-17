package com.Boxter24.EcommerceAPI.controllers;

import com.Boxter24.EcommerceAPI.models.Category;
import com.Boxter24.EcommerceAPI.models.Product;
import com.Boxter24.EcommerceAPI.services.CategoryService;
import com.Boxter24.EcommerceAPI.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce/dashboard/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
