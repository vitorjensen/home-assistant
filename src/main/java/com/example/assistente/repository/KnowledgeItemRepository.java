package com.example.assistente.repository;

import com.example.assistente.model.KnowledgeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnowledgeItemRepository extends JpaRepository<KnowledgeItem, Long> {
}
