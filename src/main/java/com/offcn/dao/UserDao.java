package com.offcn.dao;

import com.offcn.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
   public abstract int Add(User user);
   User loginByUserNameAndPassword(String userName, String password);
}
