package com.demo.project66.repository;

import java.util.List;

import com.demo.project66.domain.post4.Post4;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface Post4Repository extends CrudRepository<Post4, Long> {
    @EntityGraph(value = Post4.WITH_COMMENTS_GRAPH, type = EntityGraph.EntityGraphType.LOAD)
    List<Post4> findAll();
}