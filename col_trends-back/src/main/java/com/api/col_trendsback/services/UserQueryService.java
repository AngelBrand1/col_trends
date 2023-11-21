package com.api.col_trendsback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.col_trendsback.models.UserQuery;
import com.api.col_trendsback.repositories.UserQueryRepository;
import com.api.col_trendsback.utils.IProjectionUserQuery;
import com.api.col_trendsback.utils.QueryParameters;

@Service
public class UserQueryService {
    @Autowired
    BigQueryService _bigQueryService;

    @Autowired
    private UserQueryRepository _userQueryRepository;

    public ResponseEntity<String> saveQuery(QueryParameters queryParameters){
        String query = _bigQueryService.buildQuery(queryParameters);
        UserQuery userQuery = new UserQuery(queryParameters.getUserName(),queryParameters.getComment(),query);
        _userQueryRepository.save(userQuery);
        return ResponseEntity.ok("{\"sucess\":true,\"message\":\"query saved\"}");
    }

    public List<IProjectionUserQuery> getAll(){
        return _userQueryRepository.findByOrderByIdDesc();
    }

    public String getQuery(long id){
        UserQuery userQuery = _userQueryRepository.findById(id).get();
        return userQuery.getQueryText();
    }
}
