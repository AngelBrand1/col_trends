package com.api.col_trendsback.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.col_trendsback.models.UserQuery;
import com.api.col_trendsback.repositories.UserQueryRepository;

@RestController
@RequestMapping("/api/userquery")
public class UserQueryController {


    @Autowired
    private UserQueryRepository _userQueryRepository;

    @GetMapping
    public List<UserQuery> getUserQuery()
    {
        return _userQueryRepository.findAll();
    }
    @PostMapping
    public UserQuery creatUserQuery(@RequestBody UserQuery userQuery)
    {
        return _userQueryRepository.save(userQuery);
    }
    
}
