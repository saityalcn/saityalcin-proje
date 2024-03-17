package com.example.saityalcin.controller.contract.impl;

import com.example.saityalcin.controller.contract.RestaurantControllerContract;
import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.entity.Restaurant;
import com.example.saityalcin.map.RestaurantMapper;
import com.example.saityalcin.request.RestaurantSaveRequest;
import com.example.saityalcin.request.RestaurantUpdateRequest;
import com.example.saityalcin.service.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Log4j2
@RequiredArgsConstructor
public class RestaurantControllerContractImpl implements RestaurantControllerContract {

    private final RestaurantEntityService service;

    @Override
    public List<RestaurantDTO> findAll() {
        Stream<Restaurant> stream = StreamSupport.stream(service.findAll().spliterator(), false);
        return stream.map(RestaurantMapper.INSTANCE::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public RestaurantDTO save(RestaurantSaveRequest saveRequest) {
        Restaurant model = RestaurantMapper.INSTANCE.convertToEntity(saveRequest);
        return  RestaurantMapper.INSTANCE.convertToDTO(service.save(model));
    }

    @Override
    public RestaurantDTO update(Long id, RestaurantUpdateRequest updateRequest) {
        Restaurant model = RestaurantMapper.INSTANCE.convertUpdateRequestToEntity(updateRequest);
        model.setId(id);
        return RestaurantMapper.INSTANCE.convertToDTO(service.save(model));
    }

}
