package com.offcn.service.impl;

import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public int AddUser(User user) {
//        UserDao ud = new UserDaoImpl();
        int i = userDao.Add(user);
        return i;
    }

    @Override
    public User login(String userName, String password) {
        return userDao.loginByUserNameAndPassword(userName,password);
    }

}
