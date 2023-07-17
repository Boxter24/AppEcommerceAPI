package com.Boxter24.EcommerceAPI.repositories;

import com.Boxter24.EcommerceAPI.models.DataComponentEcommerce;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataComponentEcommerceRepository extends JpaRepository<DataComponentEcommerce, Long> {

    public void deleteAllByComponentEcommerce_Index(Long id);

}
