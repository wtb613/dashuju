package com.offcn.service;

import com.offcn.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public abstract int AddUser(User user);
    User login(String userName, String password);
}
