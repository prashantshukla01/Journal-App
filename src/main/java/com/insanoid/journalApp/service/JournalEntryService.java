package com.insanoid.journalApp.service;

import com.insanoid.journalApp.entity.JournalEntry;
import com.insanoid.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries() {
        return journalEntryRepository.findAll();
    }

    public boolean deleteEntry(String id) {
        journalEntryRepository.deleteById(id);
        return true;
    }

    public JournalEntry updateEntry(String id, JournalEntry newEntry) {
        return journalEntryRepository.findById(id)
                .map(entry -> {
                    entry.setTitle(newEntry.getTitle());
                    entry.setContent(newEntry.getContent());
                    entry.setDate(newEntry.getDate());
                    return journalEntryRepository.save(entry);
                })
                .orElseGet(() -> {
                    newEntry.setId(id);
                    return journalEntryRepository.save(newEntry);
                });
    }
}


//controller --> service --> repository