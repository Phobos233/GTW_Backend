package com.phobos.goldentrianglewebsitebackend.Model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
@Data
public class User {
    @Id
    private long id;
    private List<String> label; // labels(m):返回m节点的标签列表 属性类型是List<String>
    private String username;
    private String password;
//    private String role;
//    private String token;
}
