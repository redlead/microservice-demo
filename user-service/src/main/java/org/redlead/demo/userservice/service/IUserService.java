package org.redlead.demo.userservice.service;

import org.redlead.demo.userservice.model.User;

import java.util.List;

public interface IUserService {

    User findOneByKey(String key);
    List<User> findAll();
    User create(User user);

}
