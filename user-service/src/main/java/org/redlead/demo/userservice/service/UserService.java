package org.redlead.demo.userservice.service;

import org.redlead.demo.userservice.model.User;
import org.redlead.demo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOneByKey(String key) {
        return userRepository.findOneByKey(key);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User create(User user) {
        user.setId(null);
        return userRepository.save(user);
    }
}
