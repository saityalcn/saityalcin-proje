package com.example.saityalcin.service;

import com.example.saityalcin.dao.CommentRepository;
import com.example.saityalcin.dao.UserRepository;
import com.example.saityalcin.entity.Comment;
import com.example.saityalcin.service.generic.GenericEntityService;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService extends GenericEntityService<Comment, CommentRepository> {

    protected CommentEntityService(CommentRepository repository)  {
        super(repository);
    }


}
