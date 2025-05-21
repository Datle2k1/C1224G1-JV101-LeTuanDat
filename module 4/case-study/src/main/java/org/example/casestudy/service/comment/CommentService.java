package org.example.casestudy.service.comment;

import org.example.casestudy.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImplement {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImplement(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment() {

    }
}
