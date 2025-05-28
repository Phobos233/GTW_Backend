package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.Comment;
import com.phobos.goldentrianglewebsitebackend.Repository.CommentRepo;
import com.phobos.goldentrianglewebsitebackend.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;
    @Autowired
    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public List<Comment> getCommentsByAuthorId(long authorId) {
        return commentRepo.getCommentsByAuthorId(authorId);
    }

    @Override
    public List<Comment> getCommentsByCommentToId(long commentToId) {
        return commentRepo.getCommentsByCommentToId(commentToId);
    }

    @Override
    public List<Comment> getCommentsByAuthorIdAndCommentToId(long commentToId, long authorId) {
        return commentRepo.getCommentsByAuthorIdAndCommentToId(commentToId, authorId);
    }

    @Override
    public List<Comment> getCommentsByCommentToIdWithPage(long commentToId, int page, int limit) {
        return commentRepo.getCommentsByCommentToIdWithPage(commentToId, page, limit);
    }

    @Override
    public List<Comment> getCommentsByAuthorIdWithPage(long authorId, int page, int limit) {
        int skip = (page - 1) * limit;
        return commentRepo.getCommentByAuthorIdWithPages(authorId, skip, limit);
    }

    @Override
    public List<Comment> addComment(long authorId, long commentToId, String content) {
        return commentRepo.createComment(content, authorId, commentToId);
    }

    @Override
    public void deleteComment(long commentId) {
        commentRepo.deleteComment(commentId);
    }

    @Override
    public int getCommentCountByAuthorId(long authorId) {
        return commentRepo.countCommentByAuthorId(authorId);
    }

    @Override
    public int getCommentCountByCommentToId(long commentToId) {
        return commentRepo.countCommentByCommentToId(commentToId);
    }
}
