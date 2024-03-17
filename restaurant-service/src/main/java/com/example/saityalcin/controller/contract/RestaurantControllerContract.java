package com.example.saityalcin.controller.contract;

import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.request.RestaurantSaveRequest;
import com.example.saityalcin.request.RestaurantUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface RestaurantControllerContract {

    List<RestaurantDTO> findAll();

    RestaurantDTO save(RestaurantSaveRequest saveRequest);

    RestaurantDTO update(Long id, RestaurantUpdateRequest updateRequest);



}
