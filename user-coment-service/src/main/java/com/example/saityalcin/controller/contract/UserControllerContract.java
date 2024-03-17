package com.example.saityalcin.controller.contract;

import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.request.UserSaveRequest;
import com.example.saityalcin.request.UserUpdateRequest;

import java.util.List;
import java.util.Map;

public interface UserControllerContract {
    UserDTO save(UserSaveRequest request);

    List<UserDTO> findAll();

    UserDTO update(Long id, UserUpdateRequest updateRequest);

    Map<String, Boolean> delete(Long id);

    List<RestaurantDTO> getSuggestionList(Double userLatitude, Double userLongitude);

}