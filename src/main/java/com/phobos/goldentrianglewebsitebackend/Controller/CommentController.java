package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.Comment;
import com.phobos.goldentrianglewebsitebackend.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    private final CommentService commentService;
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //查询评论
    @RequestMapping("/comment/find/authorId")
    public List<Comment> findCommentByAuthorId(long authorId) {
        return commentService.getCommentsByAuthorId(authorId);
    }
    @RequestMapping("/comment/find/commentToId")
    public List<Comment> findCommentByCommentToId(long commentToId) {
        return commentService.getCommentsByCommentToId(commentToId);
    }
    @RequestMapping("/comment/find/authorIdAndCommentToId")
    public List<Comment> findCommentByAuthorIdAndCommentToId(long authorId, long commentToId) {
        return commentService.getCommentsByAuthorIdAndCommentToId(commentToId, authorId);
    }

    //分页查询
    @RequestMapping("/comment/find/authorId/Page")
    public List<Comment> findCommentByAuthorIdWithPage(long authorId, int page, int size) {
        return commentService.getCommentsByAuthorIdWithPage(authorId, page, size);
    }

    @RequestMapping("/comment/find/commentToId/Page")
    public List<Comment> findCommentByCommentToIdWithPage(long commentToId, int page, int size) {
        return commentService.getCommentsByCommentToIdWithPage(commentToId, page, size);
    }

    //添加评论
    @RequestMapping("/comment/create")
    public List<Comment> createComment(long authorId, long commentToId, String content) {
        return commentService.addComment(authorId, commentToId, content);
    }
    //删除评论
    @RequestMapping("/comment/delete")
    public void deleteComment(long commentId) {
        commentService.deleteComment(commentId);
    }

    //获取评论数量
    @RequestMapping("/comment/count/authorId")
    public int getCommentCountByAuthorId(long authorId) {
        return commentService.getCommentCountByAuthorId(authorId);
    }

    @RequestMapping("/comment/count/commentToId")
    public int getCommentCountByCommentToId(long commentToId) {
        return commentService.getCommentCountByCommentToId(commentToId);
    }

}
