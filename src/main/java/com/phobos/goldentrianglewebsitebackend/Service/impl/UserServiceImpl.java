package com.phobos.goldentrianglewebsitebackend.Service.impl;

import com.phobos.goldentrianglewebsitebackend.Model.User;
import com.phobos.goldentrianglewebsitebackend.Repository.UserRepo;
import com.phobos.goldentrianglewebsitebackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @Override
    public List<User> findByUsernameAndPassword(User user) {
//        System.out.println(user);
//        System.out.println("Service返回："+userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword()));
        return userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }


}
