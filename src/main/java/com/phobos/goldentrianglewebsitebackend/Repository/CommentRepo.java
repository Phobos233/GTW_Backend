package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.Comment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends Neo4jRepository<Comment, Long> {

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(m) = $authorId RETURN ID(r) as commentId" +
            ",r.content as content" +
            ",m.username as author" +
            ",ID(m) as authorId" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" +
            ",n.ch_name as commentTo" +
            ",ID(n) as commentToId")
    List<Comment> getCommentsByAuthorId(long AuthorId);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(m) = $authorId and ID(n) = $CommentToId RETURN ID(r) as commentId" +
            ",r.content as content" +
            ",m.username as author" +
            ",ID(m) as authorId" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" +
            ",n.ch_name as commentTo" +
            ",ID(n) as commentToId")
    List<Comment> getCommentsByAuthorIdAndCommentToId(long CommentToId, long AuthorId);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(n) = $CommentToId" +
            " RETURN ID(r) as commentId" +
            ",r.content as content" +
            ",m.username as author" +
            ",ID(m) as authorId" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" +
            ",n.ch_name as commentTo" +
            ",ID(n) as commentToId")
    List<Comment> getCommentsByCommentToId(long CommentToId);

    //分页查询
    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(n) = $CommentToId" +
            " RETURN ID(r) as commentId" +
            ",r.content as content" +
            ",m.username as author" +
            ",ID(m) as authorId" +
            ",apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime" +
            ",n.ch_name as commentTo" +
            ",ID(n) as commentToId"
            + " SKIP $skip LIMIT $limit")
    List<Comment> getCommentsByCommentToIdWithPage(long CommentToId, int skip, int limit);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(m) = $authorId"
            + " RETURN ID(r) as commentId"
            + ", r.content as content"
            + ", m.username as author"
            + ", ID(m) as authorId"
            + ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime"
            + ", n.ch_name as commentTo"
            + ", ID(n) as commentToId" +
            " SKIP $skip LIMIT $limit")
    List<Comment> getCommentByAuthorIdWithPages(long authorId, int skip, int limit);

    @Query("Match (m:user),(n:plant) Where ID(m)=$authorId and ID(n) = $commentToId"
            + " Create (m)-[r:comment{content:$content,timestamp:timestamp()}]->(n)"
            + " RETURN ID(r) as commentId"
            + ", r.content as content"
            + ", m.username as author"
            + ", ID(m) as authorId"
            + ", apoc.date.format(r.timestamp,'ms','yyyy/MM/dd HH:mm:ss','Asia/Shanghai') as datetime"
            + ", n.ch_name as commentTo"
            + ", ID(n) as commentToId")
    List<Comment> createComment(String content, long authorId, long commentToId);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(r) = $commentId Delete r")
    void deleteComment(long commentId);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(m) = $authorId return count(r)")
    int countCommentByAuthorId(long authorId);

    @Query("Match (m:user)-[r:comment]->(n:plant) Where ID(n) = $commentToId return count(r)")
    int countCommentByCommentToId(long commentToId);


}
