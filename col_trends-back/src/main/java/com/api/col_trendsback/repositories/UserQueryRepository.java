package com.api.col_trendsback.repositories;
// import com.api.col_trendsback.utils.
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.col_trendsback.models.UserQuery;
import com.api.col_trendsback.utils.IProjectionUserQuery;
@Repository
public interface UserQueryRepository extends JpaRepository<UserQuery, Long> {
    List<IProjectionUserQuery> findAllProjectedBy();
}