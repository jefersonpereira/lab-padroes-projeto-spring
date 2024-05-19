package br.com.sizer.controller;

import br.com.sizer.model.User;
import br.com.sizer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    // ------------------- user registration -------------------
    @PostMapping("/user")
    ResponseEntity<?> createUser(@RequestBody User request) {
        User response = userService.createUser(request);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}
