package com.api.col_trendsback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.col_trendsback.models.UserQuery;
@Repository
public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {
    
}