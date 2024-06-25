package com.demo.project66.domain.post2;

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
@Table(name = "post-comment2")
public class PostComment2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
}

