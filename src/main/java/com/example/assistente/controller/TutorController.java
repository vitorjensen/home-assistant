package com.example.assistente.controller;

import com.example.assistente.dto.PerguntaDTO;
import com.example.assistente.service.TutorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/ask")
    public String ask(@RequestBody PerguntaDTO dto) {
        return tutorService.ask(dto.getPergunta());
    }
}
