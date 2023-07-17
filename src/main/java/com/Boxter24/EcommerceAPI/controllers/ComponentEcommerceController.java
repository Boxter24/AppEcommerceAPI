package com.Boxter24.EcommerceAPI.controllers;

import com.Boxter24.EcommerceAPI.models.ComponentEcommerce;
import com.Boxter24.EcommerceAPI.services.ComponentEcommerceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/ecommerce/dashboard/ecommerce-layout")
public class ComponentEcommerceController {

    private final ComponentEcommerceService componentEcommerceService;

    @GetMapping("/all")
    public List<ComponentEcommerce> getAll(){
        return componentEcommerceService.getAll();
    }

    @PostMapping("/update")
    public List<ComponentEcommerce> updateLayout(@RequestBody List<ComponentEcommerce> componentEcommerceList){
        return componentEcommerceService.updateLayout(componentEcommerceList);
    }

}
