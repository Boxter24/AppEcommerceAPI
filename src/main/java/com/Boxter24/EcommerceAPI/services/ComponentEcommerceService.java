package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.ComponentEcommerce;
import com.Boxter24.EcommerceAPI.repositories.ComponentEcommerceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ComponentEcommerceService {

    private final ComponentEcommerceRepository componentEcommerceRepository;

    public List<ComponentEcommerce> getAll(){
        return componentEcommerceRepository.findAll();
    }


    @Transactional
    public List<ComponentEcommerce> updateLayout(List<ComponentEcommerce> componentEcommerceList){
        componentEcommerceRepository.deleteAll();
        componentEcommerceRepository.saveAll(componentEcommerceList);
        return componentEcommerceList;
    }

}
