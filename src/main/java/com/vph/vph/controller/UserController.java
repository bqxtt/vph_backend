package com.vph.vph.controller;

import com.vph.vph.entity.User;
import com.vph.vph.model.Result;
import com.vph.vph.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tcg
 * @date 2021/4/26
 */
@Api(tags = "用户")
@RestController
@RequestMapping("/vph/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody User user) {
        Result result = userService.login(user.getUsername(), user.getPassword());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody User user) {
        Result result = userService.register(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
