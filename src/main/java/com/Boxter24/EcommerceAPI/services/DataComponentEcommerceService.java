package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.DataComponentEcommerce;
import com.Boxter24.EcommerceAPI.repositories.DataComponentEcommerceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DataComponentEcommerceService {

    private final DataComponentEcommerceRepository dataComponentEcommerceRepository;

    public List<DataComponentEcommerce> getAll(){
        return dataComponentEcommerceRepository.findAll();
    }

    public List<DataComponentEcommerce> createDataComponentEcommerce(List<DataComponentEcommerce> listDataComponentEcommerce){
        return dataComponentEcommerceRepository.saveAll(listDataComponentEcommerce);
    }

    @Transactional
    public List<DataComponentEcommerce> updateDataComponentEcommerce(List<DataComponentEcommerce> listDataComponentEcommerce){

        dataComponentEcommerceRepository.deleteAllByComponentEcommerce_Index(listDataComponentEcommerce.get(0).getIndexComponentEcommerce());

        dataComponentEcommerceRepository.saveAll(listDataComponentEcommerce);

        return listDataComponentEcommerce;
    }

    public void deleteDataComponentEcommerce(Long id){
        dataComponentEcommerceRepository.deleteAllByComponentEcommerce_Index(id);
    }

}
