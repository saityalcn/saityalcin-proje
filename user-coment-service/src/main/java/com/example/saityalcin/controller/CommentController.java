package com.example.saityalcin.controller;

import com.example.saityalcin.controller.contract.CommentControllerContract;
import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.dto.CommentDTO;
import com.example.saityalcin.dto.UserDTO;
import com.example.saityalcin.request.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class CommentController {

    private final CommentControllerContract contract;


    @PostMapping
    public CommentDTO save(@RequestBody CommentSaveRequest saveRequest){
        return contract.save(saveRequest);
    }

    @GetMapping
    public List<CommentDTO> findAll(){
        return contract.findAll();
    }


    @PutMapping("/{id}")
    public CommentDTO update(@PathVariable Long id, @RequestBody CommentUpdateRequest updateRequest){
        return contract.update(id, updateRequest);
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> update(@PathVariable Long id){
        return contract.delete(id);
    }

    @PatchMapping("/{id}/point")
    public CommentDTO updatePoint(@PathVariable Long id, @RequestBody CommentUpdatePointRequest updatePointRequest){
        return contract.updatePoint(id, updatePointRequest);
    }

    @PatchMapping("/{id}/content")
    public CommentDTO updatePoint(@PathVariable Long id, @RequestBody CommentUpdateContentRequest updateContentRequest){
        return contract.updateContent(id, updateContentRequest);
    }
}
