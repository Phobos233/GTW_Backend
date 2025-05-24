package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.LikeRelationship;

import java.util.List;

public interface LikeService {

    List<LikeRelationship> findLikeRelationshipByAuthorId(long authorId);
    List<LikeRelationship> findLikeRelationshipByLikeToId(long likeToId);
    List<LikeRelationship> findLikeRelationshipByAuthorIdAndLikeToId(long authorId, long likeToId);

    List<LikeRelationship> findLikeRelationshipByAuthorIdWithPage(long authorId, int page, int limit);

    void deleteLikeRelationshipByLikeId(long id);
    List<LikeRelationship> createLikeRelationship(long authorId, long likeToId);
}
