package com.example.saityalcin.service;

import com.example.saityalcin.dao.UserRepository;
import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.entity.User;
import com.example.saityalcin.service.generic.GenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserEntityService extends GenericEntityService<User, UserRepository> {

    @Value("restaurant-service.url")
    private String RESTAURANT_API_URL;
    private final RestTemplate restTemplate;

    @Autowired
    protected UserEntityService(UserRepository repository, RestTemplate restTemplate) {
        super(repository);
        this.restTemplate = restTemplate;
    }

    public List<RestaurantDTO> getSuggestionList(Double userLatitude, Double userLongitude){

        RestaurantDTO[] restaurants = restTemplate.getForObject(RESTAURANT_API_URL + "/restaurants", RestaurantDTO[].class);
        List<RestaurantDTO> recommendedRestaurants = new ArrayList<>();

        for (RestaurantDTO restaurant : restaurants) {
            double distance = calculateDistance(userLatitude, userLongitude, restaurant.getLatitude(), restaurant.getLongitude());
            if (distance <= 10) {
                double score = calculateScore(restaurant.getRating(), distance);
                restaurant.setScore(score);
                recommendedRestaurants.add(restaurant);
            }
        }

        recommendedRestaurants.sort(Comparator.comparing(RestaurantDTO::getScore).reversed());
        return recommendedRestaurants.subList(0, Math.min(3, recommendedRestaurants.size()));
    }


    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double earthRadius = 6371; // km

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    private double calculateScore(double rating, double distance) {
        double ratingWeight = 0.7;
        double distanceWeight = 0.3;

        double distanceScore = Math.min(10 / distance, 1);

        return (rating * ratingWeight) + (distanceScore * distanceWeight);
    }

}
