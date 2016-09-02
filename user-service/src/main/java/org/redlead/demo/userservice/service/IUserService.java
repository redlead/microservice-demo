package org.redlead.demo.userservice.service;

import org.redlead.demo.userservice.model.User;

public interface IUserService {

    User findOneByKey(String key);
    User create(User user);

}
