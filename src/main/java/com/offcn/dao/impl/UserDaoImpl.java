package com.offcn.dao.impl;


import com.offcn.bean.User;
import com.offcn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jtemplate;

    public JdbcTemplate getJtemplate() {
        return jtemplate;
    }

    public void setJtemplate(JdbcTemplate jtemplate) {
        this.jtemplate = jtemplate;
    }

    @Override
    public int Add(User user) {

        String sql = "insert into user values(null,?,?,?,?,?,?)";
        int i = jtemplate.update(sql,user.getUserName(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday());
        return i;
    }

    @Override
    public User loginByUserNameAndPassword(String userName, String password) {
        String sql = "select * From user where username=? and password=?";

        return jtemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user1 = new User();
                user1.setId(rs.getInt("id"));
                user1.setUserName(rs.getString("userName"));
                user1.setPassword(rs.getString("password"));
                user1.setEmail(rs.getString("email"));
                user1.setSex(rs.getString("sex"));
                user1.setName(rs.getString("name"));
                user1.setBirthday(rs.getDate("birthday"));
                return user1;
            }
        }, new Object[]{userName, password});
    }
}
