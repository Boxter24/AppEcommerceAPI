package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.Category;
import com.Boxter24.EcommerceAPI.models.User;
import com.Boxter24.EcommerceAPI.repositories.CategoryRepository;
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
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public ResponseEntity<?> updateCategory(Category category){
        Map<String,Object> response = new HashMap<>();
        Category categoryUpdate = null;

        Category findCategory = categoryRepository.findById(category.getId()).orElse(null);

        if(findCategory == null){
            response.put("message","Failed to update Category, the Category with ID: ".concat(category.getId().toString()).concat(" do not exist"));
            return new ResponseEntity<Map<String,Object>>(response, NOT_FOUND);
        }

        try {

            findCategory.setName(category.getName());
            findCategory.setActive(category.isActive());

            categoryUpdate = categoryRepository.save(findCategory);

        }catch (DataAccessException e){
            response.put("message","Error Updating Category");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, INTERNAL_SERVER_ERROR);
        }

        response.put("message","Category Updated Successfully");
        response.put("data",categoryUpdate);

        return new ResponseEntity<Map<String ,Object>>(response, CREATED);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

}
