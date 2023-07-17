package com.Boxter24.EcommerceAPI.controllers;

import com.Boxter24.EcommerceAPI.models.DataComponentEcommerce;
import com.Boxter24.EcommerceAPI.services.DataComponentEcommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce/dashboard/ecommerce-layout/data-component")
public class DataComponentEcommerceController {

    private final DataComponentEcommerceService dataComponentEcommerceService;

    @GetMapping("/getAll")
    public List<DataComponentEcommerce> getAll(){
        return dataComponentEcommerceService.getAll();
    }

    @PostMapping("/create")
    public List<DataComponentEcommerce> createDataComponentEcommerce(@RequestBody List<DataComponentEcommerce> listDataComponentEcommerce){
        return dataComponentEcommerceService.createDataComponentEcommerce(listDataComponentEcommerce);
    }

    @PostMapping("/update")
    public List<DataComponentEcommerce> updateDataComponentEcommerce(@RequestBody List<DataComponentEcommerce> listDataComponentEcommerce){
        return dataComponentEcommerceService.updateDataComponentEcommerce(listDataComponentEcommerce);
    }

    @DeleteMapping("/delete")
    public void deleteDataComponentEcommerce(Long id){
        dataComponentEcommerceService.deleteDataComponentEcommerce(id);
    }

}
