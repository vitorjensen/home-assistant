package com.example.assistente.controller;

import com.example.assistente.model.KnowledgeInsight;
import com.example.assistente.service.KnowledgeEnrichmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/knowledge/enrich")
public class KnowledgeEnrichmentController {

    private final KnowledgeEnrichmentService service;

    public KnowledgeEnrichmentController(KnowledgeEnrichmentService service)
    {
        this.service = service;

    }
    @PostMapping("/{id}")
    public KnowledgeInsight enrich(@PathVariable Long id){
        return service.enrich(id);
    }

}
