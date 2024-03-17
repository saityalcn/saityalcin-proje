package com.example.saityalcin.map;


import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.entity.Comment;
import com.example.saityalcin.entity.User;
import com.example.saityalcin.request.CommentSaveRequest;
import com.example.saityalcin.request.UserSaveRequest;
import com.example.saityalcin.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO convertToDTO(User entity);

    User convertToEntity(UserSaveRequest saveRequest);

    User convertUpdateRequestToEntity(UserUpdateRequest updateRequest);

    List<UserDTO> convertToDTOList(List<User> entityList);

}
