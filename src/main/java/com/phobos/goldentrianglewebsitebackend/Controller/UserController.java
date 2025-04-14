package com.phobos.goldentrianglewebsitebackend.Controller;

import com.phobos.goldentrianglewebsitebackend.Model.User;
import com.phobos.goldentrianglewebsitebackend.Service.UserService;
import com.phobos.goldentrianglewebsitebackend.utils.JWTUtils;
import com.phobos.goldentrianglewebsitebackend.utils.ResultAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public ResultAPI login(@RequestBody User user) {
        System.out.println(user);
        List<User> loginUser = userService.findByUsernameAndPassword(user);
        System.out.println(loginUser.size());
         if (!loginUser.isEmpty()) {
             // 生成token
             Map<String, String> map = new HashMap<>();
             map.put("username", loginUser.getFirst().getUsername());
             map.put("id", String.valueOf(loginUser.getFirst().getId()));
             String token=JWTUtils.generateToken(map);
             return ResultAPI.success("token:"+token,"Login successful");
         } else {
             return ResultAPI.error("Login failed");
         }
     }
    @RequestMapping("/testJWT")
    public ResultAPI testJWT() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        String token=JWTUtils.generateToken(map);
        System.out.println(token);
        return ResultAPI.success("JWT test successful,token:"+token);
    }
    @RequestMapping("/testJWTParse")
    public ResultAPI testJWTParse(String token) {
        String data = JWTUtils.parseToken(token);
        return ResultAPI.success("JWT parse successful,token:"+data);
    }
}
