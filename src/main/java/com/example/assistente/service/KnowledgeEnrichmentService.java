package com.example.assistente.service;

import com.example.assistente.model.KnowledgeInsight;
import com.example.assistente.model.KnowledgeItem;
import com.example.assistente.repository.KnowledgeInsightRepository;
import com.example.assistente.repository.KnowledgeItemRepository;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeEnrichmentService {
    private final GroqService groqService;
    private final KnowledgeItemRepository itemRepository;
    private final KnowledgeInsightRepository insightRepository;

    public KnowledgeEnrichmentService(GroqService groqService, KnowledgeItemRepository itemRepository, KnowledgeInsightRepository insightRepository)
    {
    this.groqService = groqService;
    this.itemRepository = itemRepository;
    this.insightRepository = insightRepository;
    }

    public KnowledgeInsight enrich(Long knowledgeItemId){
        KnowledgeItem item = itemRepository.findById(knowledgeItemId)
                .orElseThrow(() -> new RuntimeException("KnowledgeItem não encontrado"));


        String prompt = """
        A partir do conteúdo abaixo:
        1. Gere um resumo curto (até 5 linhas)
        2. Gere 3 perguntas de revisão
        3. Liste os principais tópicos

        Conteúdo:
        %s
        """.formatted(item.getContent());
        
        String aiResponse = groqService.ask(prompt);
        KnowledgeInsight insight = new KnowledgeInsight();
        insight.setKnowledgeItem(item);
        insight.setAiSummary(aiResponse);
        insight.setReviewQuestions("Extraído do texto acima");
        insight.setTopics("Gerado automaticamente");

        return insightRepository.save(insight);
    }
}
