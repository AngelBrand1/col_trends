package com.api.col_trendsback.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.col_trendsback.models.UserQuery;
import com.api.col_trendsback.repositories.UserQueryRepository;
import com.api.col_trendsback.services.BigQueryService;
import com.api.col_trendsback.utils.QueryParameters;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9000")
public class UserQueryController {
    @Autowired
    BigQueryService _bigQueryService;

    @Autowired
    private UserQueryRepository _userQueryRepository;

    @GetMapping("/userquery")
    public List<UserQuery> getUserQuery() {
        return _userQueryRepository.findAll();
    }

    @GetMapping("/fields")
    public ResponseEntity<List<String>> getFields() {
        List<String> fields = Arrays.asList("rank", "term", "region", "percent gain");
        return ResponseEntity.ok(fields);
    }

    @PostMapping("/savequery")
    public ResponseEntity<String> creatUserQuery(@RequestBody QueryParameters queryParameters) {
        String query = _bigQueryService.buildQuery(queryParameters);
        UserQuery userQuery = new UserQuery(queryParameters.getUserName(),queryParameters.getComment(),query);
        _userQueryRepository.save(userQuery);
        return ResponseEntity.ok("Query saved");
    }
    

}
