package com.scut.onlinebookstore.serviceimpl;

import com.scut.onlinebookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private  CommentService commentService;

    @Override
    public int createComment() {
        return commentService.createComment();
    }

    @Override
    public int deleteComment(Integer commentId) {
        return commentService.deleteComment(commentId);
    }
}
