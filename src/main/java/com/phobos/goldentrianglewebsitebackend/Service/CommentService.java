package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByAuthorId(long authorId);
    List<Comment> getCommentsByCommentToId(long commentToId);
    List<Comment> getCommentsByAuthorIdAndCommentToId(long commentToId, long authorId);

    List<Comment> getCommentsByCommentToIdWithPage(long commentToId, int page, int limit);
    List<Comment> getCommentsByAuthorIdWithPage(long authorId, int page, int limit);

    List<Comment> addComment(long authorId, long commentToId, String content);
    void deleteComment(long commentId);



}
