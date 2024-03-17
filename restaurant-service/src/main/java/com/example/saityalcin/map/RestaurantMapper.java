package com.example.saityalcin.map;

import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.entity.Restaurant;
import com.example.saityalcin.request.RestaurantSaveRequest;
import com.example.saityalcin.request.RestaurantUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    RestaurantDTO convertToDTO(Restaurant entity);

    Restaurant convertToEntity(RestaurantSaveRequest saveRequest);

    Restaurant convertUpdateRequestToEntity(RestaurantUpdateRequest updateRequest);

    List<RestaurantDTO> convertToDTOList(List<Restaurant> entityList);

}
