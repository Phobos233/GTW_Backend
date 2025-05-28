package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.LikeRelationship;
import com.phobos.goldentrianglewebsitebackend.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikeController {

    private final LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @RequestMapping("/like/find/authorId")
    public List<LikeRelationship> findLikeByAuthorId(long authorId) {
        return likeService.findLikeRelationshipByAuthorId(authorId);
    }
    @RequestMapping("/like/find/likeToId")
    public List<LikeRelationship> findLikeByLikeToId(long likeToId) {
        return likeService.findLikeRelationshipByLikeToId(likeToId);
    }
    @RequestMapping("/like/find/authorIdAndLikeToId")
    public List<LikeRelationship> findLikeByAuthorIdAndLikeToId(long authorId, long likeToId) {
        return likeService.findLikeRelationshipByAuthorIdAndLikeToId(authorId, likeToId);
    }

    @RequestMapping("/like/find/authorId/Page")
    public List<LikeRelationship> findLikeByAuthorIdWithPage(long authorId, int page, int size) {
        return likeService.findLikeRelationshipByAuthorIdWithPage(authorId, page, size);
    }

    @RequestMapping("/like/create")
    public List<LikeRelationship> createLikeRelationship(long authorId, long likeToId) {
        return likeService.createLikeRelationship(authorId, likeToId);
    }

    @RequestMapping("/like/delete")
    public void deleteLike(long likeId) {
        likeService.deleteLikeRelationshipByLikeId(likeId);
    }

    @RequestMapping("/like/count/authorId")
    public int getLikeCountByAuthorId(long authorId) {
        return likeService.getLikeCountByAuthorId(authorId);
    }

}
