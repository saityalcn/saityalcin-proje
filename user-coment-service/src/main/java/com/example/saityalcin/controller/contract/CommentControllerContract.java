package com.example.saityalcin.controller.contract;

import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.request.CommentSaveRequest;
import com.example.saityalcin.request.CommentUpdateContentRequest;
import com.example.saityalcin.request.CommentUpdatePointRequest;
import com.example.saityalcin.request.CommentUpdateRequest;

import java.util.List;
import java.util.Map;

public interface CommentControllerContract {

    CommentDTO save(CommentSaveRequest request);

    List<CommentDTO> findAll();

    CommentDTO update(Long id, CommentUpdateRequest updateRequest);

    Map<String, Boolean> delete(Long id);

    CommentDTO updatePoint(Long id, CommentUpdatePointRequest updatePointRequest);

    CommentDTO updateContent(Long id, CommentUpdateContentRequest updateContentRequest);

}