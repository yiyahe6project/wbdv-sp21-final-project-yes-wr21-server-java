package com.example.wbdvsp21finalprojectyeswr21serverjava.services;

import com.example.wbdvsp21finalprojectyeswr21serverjava.models.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class UserService {
    List<User> users = new ArrayList<User>();

    public User register(User user, HttpSession session) {
        session.setAttribute("profile", user);
        users.add(user);
        User returnUser = new User(user);
        returnUser.setPassword("***");
        return returnUser;
    }

    public User profile(HttpSession session) {
        return (User) session.getAttribute("profile");
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

    public User login(User credentials, HttpSession session) {
        for (User user : users) {
            if (user.getUsername().equals(credentials.getUsername())
                    && user.getPassword().equals(credentials.getPassword())) {
                session.setAttribute("profile", user);
                return user;
            }
        }
        return null;
    }
}
