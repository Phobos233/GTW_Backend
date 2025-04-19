package com.phobos.goldentrianglewebsitebackend.Repository;

import com.phobos.goldentrianglewebsitebackend.Model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends Neo4jRepository<User, Long> {

    // 通过用户名和密码查找用户
    @Query("Match (m:user) Where m.username = $username and m.password = $password return ID(m) as id,Labels(m) as label,m.username as username,m.password as password")
    List<User> findByUsernameAndPassword(String username, String password);
    @Query("Match (m:user) Where m.username = $username and ID(m) = $id return ID(m) as id,Labels(m) as label,m.username as username,m.password as password")
    List<User> findUserByUsernameAndId(String username,long id);
    @Query("Match (m:user) return ID(m) as id,Labels(m) as label,m.username as username,m.password as password")
    List<User> findAllUser();

}
