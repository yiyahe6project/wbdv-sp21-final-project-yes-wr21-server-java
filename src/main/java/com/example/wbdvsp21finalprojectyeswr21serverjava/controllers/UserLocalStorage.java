package com.example.wbdvsp21finalprojectyeswr21serverjava.controllers;

import com.example.wbdvsp21finalprojectyeswr21serverjava.models.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*")

public class UserLocalStorage {

    List<User> users = new ArrayList<User>();

    @GetMapping("/api/register/{u}/{p}")
    public User register(
            @PathVariable("u") String username,
            @PathVariable("p") String password,
            HttpSession session) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        session.setAttribute("currentUser", user);
        users.add(user);
        return user;
    }

    @GetMapping("/api/profile")
    public User profile(HttpSession session) {
        User currentUser = (User)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @GetMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    @GetMapping("/api/login/{u}/{p}")
    public User login(
            @PathVariable("u") String username,
            @PathVariable("p") String password,
            HttpSession session) {
        for (User user : users) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                session.setAttribute("currentUser", user);
                return user;
            }
        }
        return null;
    }


    @GetMapping("/api/session/set/{attr}/{value}")
    public String setSessionAttribute(
            @PathVariable("attr") String attr,
            @PathVariable("value") String value,
            HttpSession session) {
        session.setAttribute(attr, value);
        return attr + " = " + value;
    }

    @GetMapping("/api/session/get/{attr}")
    public String getSessionAttribute(
            @PathVariable("attr") String attr,
            HttpSession session) {
        return (String) session.getAttribute(attr);
    }

}
