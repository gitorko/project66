package com.demo.project66.domain.post3;

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
@Table(name = "post-comment3")
public class PostComment3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String comment;
}

