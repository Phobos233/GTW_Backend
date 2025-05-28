package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.LikeRelationship;
import com.phobos.goldentrianglewebsitebackend.Repository.LikeRepo;
import com.phobos.goldentrianglewebsitebackend.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepo likeRepo;

    @Autowired
    public LikeServiceImpl(LikeRepo likeRepo) {
        this.likeRepo = likeRepo;
    }


    @Override
    public List<LikeRelationship> findLikeRelationshipByAuthorId(long authorId) {
        return likeRepo.findLikeRelationshipByAuthorId(authorId);
    }

    @Override
    public List<LikeRelationship> findLikeRelationshipByLikeToId(long likeToId) {
        return likeRepo.findLikeRelationshipByLikeToId(likeToId);
    }

    @Override
    public List<LikeRelationship> findLikeRelationshipByAuthorIdAndLikeToId(long authorId, long likeToId) {
        return likeRepo.findLikeRelationshipByAuthorIdAndLikeToId(authorId, likeToId);
    }

    @Override
    public List<LikeRelationship> findLikeRelationshipByAuthorIdWithPage(long authorId, int page, int limit) {
        int skip = (page - 1) * limit;
        return likeRepo.findLikeRelationshipByAuthorIdWithPage(authorId, skip, limit);
    }

    @Override
    public void deleteLikeRelationshipByLikeId(long id) {
        likeRepo.deleteLikeRelationshipByLikeId(id);
    }

    @Override
    public List<LikeRelationship> createLikeRelationship(long authorId, long likeToId) {
        return likeRepo.createLikeRelationship(authorId, likeToId);
    }

    @Override
    public int getLikeCountByAuthorId(long authorId) {
        return likeRepo.countLikeByAuthorId(authorId);
    }
}
