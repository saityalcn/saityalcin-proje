package com.example.saityalcin.map;

import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.entity.Comment;
import com.example.saityalcin.request.CommentSaveRequest;
import com.example.saityalcin.request.CommentUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO convertToDTO(Comment entity);

    Comment convertToEntity(CommentSaveRequest saveRequest);

    Comment convertUpdateRequestToEntity(CommentUpdateRequest updateRequest);

    List<CommentDTO> convertToDTOList(List<Comment> entityList);
}
