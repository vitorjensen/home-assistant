package com.example.assistente.service;

import com.example.assistente.model.Note;
import com.example.assistente.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note create(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        note.setLastReview(LocalDateTime.now());
        note.setMasteryLevel(0);
        return repository.save(note);
    }

    public List<Note> findAll() {
        return repository.findAll();
    }
}
