package com.demo.project66.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import com.demo.project66.domain.post1.Post1;
import com.demo.project66.domain.post1.PostComment1;
import com.demo.project66.domain.post2.Post2;
import com.demo.project66.domain.post2.PostComment2;
import com.demo.project66.domain.post3.Post3;
import com.demo.project66.domain.post3.PostComment3;
import com.demo.project66.domain.post4.Post4;
import com.demo.project66.domain.post4.PostComment4;
import com.demo.project66.repository.Post1Repository;
import com.demo.project66.repository.Post2Repository;
import com.demo.project66.repository.Post3Repository;
import com.demo.project66.repository.Post4Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    final Post1Repository postRepository1;
    final Post2Repository postRepository2;
    final Post3Repository postRepository3;
    final Post4Repository postRepository4;

    public Iterable<Post1> getAllPostsNPlus1() {
        Iterable<Post1> posts = postRepository1.findAll();
        for (Post1 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment1> comments = post.getComments();
            for (PostComment1 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public Iterable<Post1> getAllPostsJoinLeft() {
        Iterable<Post1> posts = postRepository1.findAllJoinLeft();
        for (Post1 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment1> comments = post.getComments();
            for (PostComment1 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public Iterable<Post1> getAllPostsJoin() {
        Iterable<Post1> posts = postRepository1.findAllJoin();
        for (Post1 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment1> comments = post.getComments();
            for (PostComment1 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public Iterable<Post4> getAllPostsGraph() {
        Iterable<Post4> posts = postRepository4.findAll();
        for (Post4 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment4> comments = post.getComments();
            for (PostComment4 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public Iterable<Post2> getAllPostsBatch() {
        Iterable<Post2> posts = postRepository2.findAll();
        for (Post2 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment2> comments = post.getComments();
            for (PostComment2 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public Iterable<Post3> getAllPostsSubSelect() {
        Iterable<Post3> posts = postRepository3.findAll();
        for (Post3 post : posts) {
            log.info("Post Title: {}", post.getTitle());
            List<PostComment3> comments = post.getComments();
            for (PostComment3 comment : comments) {
                log.info("Post Comment: {}", comment);
            }
        }
        return posts;
    }

    public void seedData() {
        postRepository1.deleteAll();
        postRepository2.deleteAll();
        postRepository3.deleteAll();

        IntStream.range(1, 10).forEach(i -> {
            List<PostComment1> comments1 = Arrays.asList(
                    PostComment1.builder().comment("Comment 1 for " + i).build(),
                    PostComment1.builder().comment("Comment 2 for " + i).build(),
                    PostComment1.builder().comment("Comment 3 for " + i).build()
            );
            List<PostComment2> comments2 = Arrays.asList(
                    PostComment2.builder().comment("Comment 1 for " + i).build(),
                    PostComment2.builder().comment("Comment 2 for " + i).build(),
                    PostComment2.builder().comment("Comment 3 for " + i).build()
            );
            List<PostComment3> comments3 = Arrays.asList(
                    PostComment3.builder().comment("Comment 1 for " + i).build(),
                    PostComment3.builder().comment("Comment 2 for " + i).build(),
                    PostComment3.builder().comment("Comment 3 for " + i).build()
            );
            List<PostComment4> comments4 = Arrays.asList(
                    PostComment4.builder().comment("Comment 1 for " + i).build(),
                    PostComment4.builder().comment("Comment 2 for " + i).build(),
                    PostComment4.builder().comment("Comment 3 for " + i).build()
            );
            postRepository1.save(Post1.builder().title("My Post " + i).comments(comments1).build());
            postRepository2.save(Post2.builder().title("My Post " + i).comments(comments2).build());
            postRepository3.save(Post3.builder().title("My Post " + i).comments(comments3).build());
            postRepository4.save(Post4.builder().title("My Post " + i).comments(comments4).build());
        });
    }

}
