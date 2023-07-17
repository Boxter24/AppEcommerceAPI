package com.Boxter24.EcommerceAPI.repositories;

import com.Boxter24.EcommerceAPI.models.ComponentEcommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface ComponentEcommerceRepository extends JpaRepository<ComponentEcommerce, Long> {

}
