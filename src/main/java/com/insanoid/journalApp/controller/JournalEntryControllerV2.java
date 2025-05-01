package com.insanoid.journalApp.controller;

import com.insanoid.journalApp.entity.JournalEntry;
import com.insanoid.journalApp.repository.JournalEntryRepository;
import com.insanoid.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2  {
    @Autowired
    private JournalEntryService journalEntryService ;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAllEntries();
    }


    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
       return true;
    }
    @GetMapping("/id/{MyId}")
    public JournalEntry getJournalEntryById(@PathVariable long MyId){
        return null;
    }
    @DeleteMapping("/id/{id}")
    public boolean deleteJournalEntryById(@PathVariable String id) {
        return journalEntryService.deleteEntry(id);
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(
            @PathVariable String id,
            @RequestBody JournalEntry myEntry
    ) {
        return journalEntryService.updateEntry(id, myEntry);
    }
}

