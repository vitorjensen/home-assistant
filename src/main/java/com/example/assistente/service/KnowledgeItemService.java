package com.example.assistente.service;

import com.example.assistente.model.KnowledgeItem;
import com.example.assistente.repository.KnowledgeItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgeItemService {
    private final KnowledgeItemRepository repository;

    public KnowledgeItemService(KnowledgeItemRepository repository)
    {
        this.repository = repository;
    }

    public KnowledgeItem save(KnowledgeItem item){
        return repository.save(item);
    }

    public List<KnowledgeItem> findAll()
    {
        return repository.findAll();
    }
}
