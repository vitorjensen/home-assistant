package com.example.assistente.controller;

import com.example.assistente.model.KnowledgeItem;
import com.example.assistente.service.KnowledgeItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/knowledge")
public class KnowledgeItemController {

    private final KnowledgeItemService service;

    public KnowledgeItemController(KnowledgeItemService service)
    {
        this.service = service;
    }

    @PostMapping
    public KnowledgeItem create(@RequestBody KnowledgeItem item)
    {
        return service.save(item);
    }

    @GetMapping
    public List<KnowledgeItem> list()
    {
        return service.findAll();
    }
}
