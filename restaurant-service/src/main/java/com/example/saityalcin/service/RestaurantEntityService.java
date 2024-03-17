package com.example.saityalcin.service;

import com.example.saityalcin.dao.RestaurantRepository;
import com.example.saityalcin.entity.Restaurant;
import com.example.saityalcin.service.generic.GenericEntityService;

public class RestaurantEntityService extends GenericEntityService<Restaurant, RestaurantRepository> {
    protected RestaurantEntityService(RestaurantRepository repository) {
        super(repository);
    }
}
