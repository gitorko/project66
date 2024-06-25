package com.demo.project66.repository;

import java.util.List;

import com.demo.project66.domain.post1.Post1;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface Post1Repository extends CrudRepository<Post1, Long> {

    @Query("SELECT p FROM Post1 p LEFT JOIN FETCH p.comments")
    List<Post1> findAllJoinLeft();

    @Query("SELECT p FROM Post1 p JOIN FETCH p.comments")
    List<Post1> findAllJoin();

}