package com.example.assistente.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class KnowledgeItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(length = 2000)
    private String summary;

    @Column(length = 10000)
    private String content;

    private String sourceType; //pdf, link, curso, anotacao...

    private LocalDateTime createdAt = LocalDateTime.now();
}
