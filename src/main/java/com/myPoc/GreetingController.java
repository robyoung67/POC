package com.myPoc;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.myPoc.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class GreetingController {

    private static final String TEMPLATE = "%s!";

    @RequestMapping("/user")
    public HttpEntity<User> user(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "userId", required = false, defaultValue = "MyID") String userId) {

        User user = new User(String.format(TEMPLATE, name),userId);
        user.add(linkTo(methodOn(GreetingController.class).user(name, userId)).withSelfRel());

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}