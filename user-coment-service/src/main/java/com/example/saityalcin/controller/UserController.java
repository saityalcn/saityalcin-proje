package com.example.saityalcin.controller;

import com.example.saityalcin.controller.contract.UserControllerContract;
import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.request.UserSaveRequest;
import com.example.saityalcin.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class UserController {

    private final UserControllerContract contract;

    @PostMapping
    public UserDTO save(@RequestBody UserSaveRequest saveRequest){
        return contract.save(saveRequest);
    }

    @GetMapping
    public List<UserDTO> findAll(){
        return contract.findAll();
    }


    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        return contract.update(id, userUpdateRequest);
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> delete(@PathVariable Long id){
        return contract.delete(id);
    }

    @GetMapping("/suggestion")
    public List<RestaurantDTO> getSuggestionList(@Param("latitude") Double userLatitude, @Param("longitude") Double userLongitude){
        return contract.getSuggestionList(userLatitude, userLongitude);
    }



}
