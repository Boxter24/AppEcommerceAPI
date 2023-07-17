package com.Boxter24.EcommerceAPI.repositories;

import com.Boxter24.EcommerceAPI.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
