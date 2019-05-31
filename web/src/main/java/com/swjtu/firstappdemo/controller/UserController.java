package com.swjtu.firstappdemo.controller;

import com.swjtu.firstappdemo.repository.UserRepository;
import com.swjtu.firstappdemo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李天峒
 * @date 2019/5/29 0:22
 */
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam("name") String name){
        User user = new User();
        user.setName(name);
        if(userRepository.save(user)) {
            logger.info("【用户添加成功】,user ={}",user.toString());
        }
        return user;
    }
}
