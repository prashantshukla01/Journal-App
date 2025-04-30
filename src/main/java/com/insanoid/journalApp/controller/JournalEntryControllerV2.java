package com.insanoid.journalApp.controller;

import com.insanoid.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2  {
    @GetMapping
    public List<JournalEntry> getAll(){
            return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
       return true;
    }
    @GetMapping("/id/{MyId}")
    public JournalEntry getJournalEntryById(@PathVariable long MyId){
        return null;
    }
    @DeleteMapping("/id/{MyId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long MyId){
        return null;
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id,@RequestBody JournalEntry myEntry){
       return null;
    }
}

