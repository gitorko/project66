package com.demo.project66;

import java.util.Arrays;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    @Autowired
    MyService myService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            myService.seedData();
            myService.getData();
        };
    }

}

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToMany(cascade = { CascadeType.ALL })
    private List<PostComment> comments;
}

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
}

interface PostRepository extends CrudRepository<Post, Long> {
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.comments")
    List<Post> findAllApproach1();

    @EntityGraph(attributePaths = {"comments"})
    List<Post> findAll();
}

@Component
class MyService {
    @Autowired
    PostRepository postRepository;

    @Transactional
    public void getData() {
        Iterable<Post> all = postRepository.findAll();
//        Iterable<Post> all = postRepository.findAllApproach1();
        for (Post post : all) {
            System.out.println(post.getTitle());
            List<PostComment> comments = post.getComments();
            for (PostComment comment : comments) {
                System.out.println(comment);
            }
        }
    }

    public void seedData() {
        postRepository.deleteAll();
        for (int i = 1; i <= 5; i++) {
            List<PostComment> comments = Arrays.asList(
                    PostComment.builder().comment("Comment 1 for " + i).build(),
                    PostComment.builder().comment("Comment 2 for " + i).build(),
                    PostComment.builder().comment("Comment 3 for " + i).build()
            );
            postRepository.save(Post.builder().title("My Post " + i).comments(comments).build());
        }

    }
}
