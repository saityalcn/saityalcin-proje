package com.example.saityalcin.controller.contract.impl;

import com.example.saityalcin.controller.contract.UserControllerContract;
import com.example.saityalcin.dto.RestaurantDTO;
import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.entity.User;
import com.example.saityalcin.map.UserMapper;
import com.example.saityalcin.request.UserSaveRequest;
import com.example.saityalcin.request.UserUpdateRequest;
import com.example.saityalcin.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract {

    private final UserEntityService service;

    @Override
    public UserDTO save(UserSaveRequest request) {
        log.info("Save User Request: " + request);
        User user = UserMapper.INSTANCE.convertToEntity(request);
        return UserMapper.INSTANCE.convertToDTO(service.save(user));
    }

    @Override
    public List<UserDTO> findAll() {
        log.info("All Users Requested");
        return UserMapper.INSTANCE.convertToDTOList(service.findAll());
    }

    @Override
    public UserDTO update(Long id, UserUpdateRequest updateRequest) {
        log.info("Update User Request Id: " + id);
        log.info("Update User Request Update Request: " + updateRequest);
        User user = UserMapper.INSTANCE.convertUpdateRequestToEntity(updateRequest);
        user.setId(id);
        return UserMapper.INSTANCE.convertToDTO(service.save(user));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        log.info("Delete User Request Id: " +  id);
        Map<String, Boolean> resMap = new HashMap<>();
        try{
            service.delete(id);
            resMap.put("deleted", Boolean.TRUE);
            return resMap;
        } catch (Exception e){
            log.error("Error when deleting comment. ");
            log.error(e.getMessage());
            resMap.put("deleted", Boolean.FALSE);
            return resMap;
        }
    }

    @Override
    public List<RestaurantDTO> getSuggestionList(Double userLatitude, Double userLongitude) {
        return service.getSuggestionList(userLatitude, userLongitude);
    }

}