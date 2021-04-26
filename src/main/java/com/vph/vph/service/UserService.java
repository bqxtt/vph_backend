package com.vph.vph.service;

import com.vph.vph.entity.User;
import com.vph.vph.mapper.UserMapper;
import com.vph.vph.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Result login(String username, String password) {
        Result result;
        try {
            User user = userMapper.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                result = Result.retOk("login success");
            } else {
                result = Result.retFail("login failed");
            }
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

    public Result register(User user) {
        Result result;
        try {
            User user1 = userMapper.getUserByUsername(user.getUsername());
            if (user1 != null) {
                result = Result.retFail("already exist");
            } else {
                userMapper.addUser(user);
                result = Result.retOk("register success");
            }
        } catch (Exception e) {
            result = Result.retFail(e.getMessage());
        }
        return result;
    }

}
