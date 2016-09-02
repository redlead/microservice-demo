package org.redlead.demo.userservice.testdata;

import org.redlead.demo.userservice.model.User;
import org.redlead.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestData {

    @Autowired
    private UserService userService;

    @PostConstruct
    void generate() {
        userService.create(new User(null, "DENT", "Arthur Dent"));
        userService.create(new User(null, "ZAPHOD", "Zaphod Beeblebrox"));
        userService.create(new User(null, "PREFECT", "Ford Prefect"));
    }
}
