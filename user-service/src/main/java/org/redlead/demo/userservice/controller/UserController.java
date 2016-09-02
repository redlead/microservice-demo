package org.redlead.demo.userservice.controller;

import org.redlead.demo.userservice.model.User;
import org.redlead.demo.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "/{key}", method = GET, produces = APPLICATION_JSON_UTF8_VALUE)
    User getOneByKey(@PathVariable String key) {
        return userService.findOneByKey(key);
    }
}
