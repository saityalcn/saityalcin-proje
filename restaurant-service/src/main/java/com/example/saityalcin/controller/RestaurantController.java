package com.example.saityalcin.controller;

import com.example.saityalcin.controller.contract.RestaurantControllerContract;
import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.entity.Restaurant;
import com.example.saityalcin.request.RestaurantSaveRequest;
import com.example.saityalcin.request.RestaurantUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/restaurant")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantControllerContract contract;


    @GetMapping
    public List<RestaurantDTO> findAll(){
        return contract.findAll();
    }

    @PostMapping
    public RestaurantDTO save(@RequestBody RestaurantSaveRequest saveRequest){
        return contract.save(saveRequest);
    }

    @PutMapping("/{id}")
    public RestaurantDTO update(@PathVariable Long id, @RequestBody RestaurantUpdateRequest updateRequest){
        return contract.update(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        contract.delete(id);
    }


}
