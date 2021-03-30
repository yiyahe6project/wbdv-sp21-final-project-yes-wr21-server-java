package com.example.wbdvsp21finalprojectyeswr21serverjava.controllers;

import com.example.wbdvsp21finalprojectyeswr21serverjava.models.User;
import com.example.wbdvsp21finalprojectyeswr21serverjava.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/api/register")
    public User register(
            @RequestBody User user,
            HttpSession session) {
        return service.register(user, session);
    }

    @PostMapping("/api/profile")
    public User profile(HttpSession session) {
        return service.profile(session);
    }

    @PostMapping("/api/logout")
    public void logout(HttpSession session) {
        service.logout(session);
    }

    @PostMapping("/api/login")
    public User login(
            @RequestBody User credentials,
            HttpSession session) {
        return service.login(credentials, session);
    }


//    @GetMapping("/api/session/set/{attr}/{value}")
//    public String setSessionAttribute(
//            @PathVariable("attr") String attr,
//            @PathVariable("value") String value,
//            HttpSession session) {
//        session.setAttribute(attr, value);
//        return attr + " = " + value;
//    }
//
//    @GetMapping("/api/session/get/{attr}")
//    public String getSessionAttribute(
//            @PathVariable("attr") String attr,
//            HttpSession session) {
//        return (String) session.getAttribute(attr);
//    }

}
