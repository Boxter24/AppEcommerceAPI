package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.Product;
import com.Boxter24.EcommerceAPI.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public ResponseEntity<?> updateProduct(Product product){
        Map<String,Object> response = new HashMap<>();
        Product productUpdate = null;

        Product findProduct = productRepository.findById(product.getId()).orElse(null);

        if(findProduct == null){
            response.put("message","Failed to update Product, the Product with ID: ".concat(product.getId().toString()).concat(" do not exist"));
            return new ResponseEntity<Map<String,Object>>(response, NOT_FOUND);
        }

        try {

            findProduct.setName(product.getName());
            findProduct.setPrice((product.getPrice()));
            findProduct.setDescription(product.getDescription());
            findProduct.setQuantity(product.getQuantity());
            findProduct.setCategory(product.getCategory());

            productUpdate = productRepository.save(findProduct);

        }catch (DataAccessException e){
            response.put("message","Error Updating Product");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, INTERNAL_SERVER_ERROR);
        }

        response.put("message","Product Updated Successfully");
        response.put("data",productUpdate);

        return new ResponseEntity<Map<String ,Object>>(response, CREATED);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

}
