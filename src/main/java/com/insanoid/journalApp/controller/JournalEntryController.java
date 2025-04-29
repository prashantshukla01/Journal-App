package com.insanoid.journalApp.controller;

import com.insanoid.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController  {
    private Map<Long , JournalEntry> journalEntries = new HashMap();
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(),myEntry);
        return true;
    }
    @GetMapping("/id/{MyId}")
    public JournalEntry getJournalEntryById(@PathVariable long MyId){
       return  journalEntries.get(MyId);
    }
    @DeleteMapping("/id/{MyId}")
    public JournalEntry deleteJournalEntryById(@PathVariable long MyId){
        return  journalEntries.remove(MyId);
    }
    @PutMapping("/id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable long id,@RequestBody JournalEntry myEntry){
        return journalEntries.put(id,myEntry);
    }
}
