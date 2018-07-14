package com.project.cc.ccbackend.controller.authentication;

import com.project.cc.ccbackend.model.User;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Log4j
public class AuthenticationController {

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public User login(@PathVariable String name) {
        return null;
    }
}
