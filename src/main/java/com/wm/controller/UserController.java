package com.wm.controller;

import com.wm.entity.User;
import com.wm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private AmqpTemplate amqpTemplate;

    @GetMapping("/find")
    public List<User> getAllUsers(@RequestParam("date") Date date) {
        logger.info(date.toString());
        this.amqpTemplate.convertAndSend("string", date.toString());
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id,
                                        @RequestParam("username") String userName,
                                        @RequestParam("password") String passWord){
        User user = userService.findAllById(id);
        user.setId(id);
        user.setUserName(userName);
        user.setPassWord(passWord);
        User use = userService.updateUserById(user);
        return ResponseEntity.ok(use);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id){
        User user = userService.deleteUserById(id);
        return ResponseEntity.ok(user);
    }

}
