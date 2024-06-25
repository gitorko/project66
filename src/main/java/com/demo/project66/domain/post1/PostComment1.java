package com.demo.project66.domain.post1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "post-comment1")
public class PostComment1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
}

