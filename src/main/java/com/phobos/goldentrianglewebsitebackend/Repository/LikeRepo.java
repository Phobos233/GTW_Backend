package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.LikeRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface LikeRepo extends Neo4jRepository<LikeRelationship,Long> {

    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(n) = $likeToId " +
            "return ID(r) as id" +
            ",ID(m) as authorId" +
            ",ID(n) as likeToId" +
            ",m.username as author" +
            ",n.ch_name as likeTo" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" )
    List<LikeRelationship> findLikeRelationshipByLikeToId(long LikeToId);

    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(m) = $authorId " +
            "return ID(r) as id" +
            ",ID(m) as authorId" +
            ",ID(n) as likeToId" +
            ",m.username as author" +
            ",n.ch_name as likeTo" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" )
    List<LikeRelationship> findLikeRelationshipByAuthorId(long AuthorId);

    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(m) = $authorId and ID(n) = $likeToId " +
            "return ID(r) as id" +
            ",ID(m) as authorId" +
            ",ID(n) as likeToId" +
            ",m.username as author" +
            ",n.ch_name as likeTo" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" )
    List<LikeRelationship> findLikeRelationshipByAuthorIdAndLikeToId(long authorId, long likeToId);

    //分页查询
    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(m) = $authorId " +
            "return ID(r) as id" +
            ",ID(m) as authorId" +
            ",ID(n) as likeToId" +
            ",m.username as author" +
            ",n.ch_name as likeTo" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" +
            " SKIP $skip LIMIT $limit")
    List<LikeRelationship> findLikeRelationshipByAuthorIdWithPage(long authorId, long skip, long limit);


    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(r) = $id " +
            "Delete r")
    void deleteLikeRelationshipByLikeId(long id);

    @Query("Match (m:user),(n:plant) Where ID(m) = $authorId and ID(n) = $likeToId " +
            "Create (m)-[r:like{timestamp:timestamp()}]->(n) " +
            "Return ID(r) as id" +
            ",ID(m) as authorId" +
            ",ID(n) as likeToId" +
            ",m.username as author" +
            ",n.ch_name as likeTo" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" )
    List<LikeRelationship> createLikeRelationship(long authorId, long likeToId);

    @Query("Match (m:user)-[r:like]->(n:plant) Where ID(m) = $authorId return count(r)" )
    int countLikeByAuthorId(long authorId);
}
