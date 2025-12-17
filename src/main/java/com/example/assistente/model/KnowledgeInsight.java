package com.example.assistente.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

/*Modelo para armazenar os insights do GROQ em resposta ao KnowledgeItem*/
public class KnowledgeInsight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private KnowledgeItem knowledgeItem;

    @Column(length = 2000)
    private String aiSummary;

    @Column(length = 3000)
    private String reviewQuestions; // Pode ser texto ou JSON

    private String topics; //ex: Spring-Boot, REST, JPA
}
