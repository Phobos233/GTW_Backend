package com.phobos.goldentrianglewebsitebackend.Service;

import com.phobos.goldentrianglewebsitebackend.Model.User;

import java.util.List;

public interface UserService {

    List<User> findByUsernameAndPassword(User user);
}
