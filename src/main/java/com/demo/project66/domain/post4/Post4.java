package com.demo.project66.domain.post4;

import static com.demo.project66.domain.post4.Post4.WITH_COMMENTS_GRAPH;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post4")
@NamedEntityGraph(name = WITH_COMMENTS_GRAPH,
        attributeNodes = @NamedAttributeNode("comments"))
public class Post4 {
    public static final String WITH_COMMENTS_GRAPH = "graph.post.comments";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<PostComment4> comments;
}