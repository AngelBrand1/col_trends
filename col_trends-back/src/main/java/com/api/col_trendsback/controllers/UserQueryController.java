package com.api.col_trendsback.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.api.col_trendsback.models.UserQuery;
import com.api.col_trendsback.repositories.UserQueryRepository;
import com.google.api.services.bigquery.model.QueryParameter;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserQueryController {

    @Autowired
    private UserQueryRepository _userQueryRepository;

    @GetMapping("/userquery")
    public List<UserQuery> getUserQuery() {
        return _userQueryRepository.findAll();
    }

    @GetMapping("/fields")
    public ResponseEntity<Map<String, Object>> tuMetodoQueRetornaArrays() {
        String[] internationalTop = { "rank", "term", "region" };
        String[] top = { "designed market area"};

        Map<String, Object> response = new HashMap<>();
        response.put("internationalTop", internationalTop);
        response.put("top", top);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/createuser")
    public UserQuery creatUserQuery(@RequestBody UserQuery userQuery) {
        return _userQueryRepository.save(userQuery);
    }

    @PostMapping("/createquery")
    public ResponseEntity<QueryParameter> createQuery(@RequestBody QueryParameter queryParameter) {
        QueryParameter temp = queryParameter;
        return ResponseEntity.ok(queryParameter);
    }
    

}
