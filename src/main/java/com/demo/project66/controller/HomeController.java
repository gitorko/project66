package com.demo.project66.controller;

import com.demo.project66.domain.post1.Post1;
import com.demo.project66.domain.post2.Post2;
import com.demo.project66.domain.post3.Post3;
import com.demo.project66.domain.post4.Post4;
import com.demo.project66.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class HomeController {

    final PostService postService;

    @GetMapping("/default")
    public Iterable<Post1> getAllPostsNPlus1() {
        return postService.getAllPostsNPlus1();
    }

    @GetMapping("/join-left")
    public Iterable<Post1> getAllPostsJoinLeft() {
        return postService.getAllPostsJoinLeft();
    }

    @GetMapping("/join")
    public Iterable<Post1> getAllPostsJoin() {
        return postService.getAllPostsJoin();
    }

    @GetMapping("/batch")
    public Iterable<Post2> getAllPostsBatch() {
        return postService.getAllPostsBatch();
    }

    @GetMapping("/sub-select")
    public Iterable<Post3> getAllPostsSubSelect() {
        return postService.getAllPostsSubSelect();
    }

    @GetMapping("/graph")
    public Iterable<Post4> getAllPostsGraph() {
        return postService.getAllPostsGraph();
    }

}
