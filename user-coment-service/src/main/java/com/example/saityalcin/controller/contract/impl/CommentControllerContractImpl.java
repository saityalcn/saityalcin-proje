package com.example.saityalcin.controller.contract.impl;

import com.example.saityalcin.controller.contract.CommentControllerContract;
import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.entity.Comment;
import com.example.saityalcin.map.CommentMapper;
import com.example.saityalcin.request.CommentSaveRequest;
import com.example.saityalcin.request.CommentUpdateContentRequest;
import com.example.saityalcin.request.CommentUpdatePointRequest;
import com.example.saityalcin.request.CommentUpdateRequest;
import com.example.saityalcin.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService service;

    @Override
    public CommentDTO save(CommentSaveRequest request) {
        log.info("Save Comment Request: " + request);
        Comment comment = CommentMapper.INSTANCE.convertToEntity(request);
        return CommentMapper.INSTANCE.convertToDTO(service.save(comment));
    }

    @Override
    public List<CommentDTO> findAll() {
        log.info("All Comments Requested.");
        return CommentMapper.INSTANCE.convertToDTOList(service.findAll());
    }

    @Override
    public CommentDTO update(Long id, CommentUpdateRequest updateRequest) {
        log.info("Update Comment Request: " +  updateRequest);
        Comment comment = CommentMapper.INSTANCE.convertUpdateRequestToEntity(updateRequest);
        comment.setId(id);
        return CommentMapper.INSTANCE.convertToDTO(service.save(comment));
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        log.info("Delete Comment Request Id: " +  id);
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
    public CommentDTO updateContent(Long id, CommentUpdateContentRequest updateContentRequest) {
        log.info("Update Comment Content Request Id: " +  id);
        log.info("Update Comment Content Request Content: " +  updateContentRequest.content());
        Comment comment = service.findById(id);
        comment.setContent(updateContentRequest.content());
        return CommentMapper.INSTANCE.convertToDTO(service.save(comment));
    }

    @Override
    public CommentDTO updatePoint(Long id, CommentUpdatePointRequest updatePointRequest) {
        log.info("Update Comment Point Request Id: " +  id);
        log.info("Update Comment Point Request Point: " +  updatePointRequest.point());
        Comment comment = service.findById(id);
        comment.setPoint(updatePointRequest.point());
        return CommentMapper.INSTANCE.convertToDTO(service.save(comment));
    }

}
