package com.diary.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diary.api.entities.Entry;
import com.diary.api.service.EntryService;

@RestController
public class EntryController {
	
	@Autowired
	private EntryService entryService;
	
	@GetMapping("/entries/")
	public List<Entry> findAllEnties(){
		List<Entry> entrieslist = entryService.findAll();
		
		return entrieslist;
	}
	
	@PostMapping("/entries/")
	public Entry saveEntry(@RequestBody Entry entry) {
		Entry savedEntry = entryService.saveEntry(entry);
		
		return savedEntry;	
	}
	
	@PutMapping("/entries/")
	public Entry updateEntry1(@RequestBody Entry entry) {
		Entry updateEntry = entryService.updateEntry(entry);
		
		return updateEntry;	
	}
	
	
	@PutMapping("/entries/{id}")
	public Entry updateEntry2(@PathVariable("id") Long id, @RequestBody Entry entry) {
		
		Entry entry1 = entryService.findById(id);
		
		entry1.setEntryDate(entry.getEntryDate());
		entry1.setDescription(entry.getDescription());
		entry1.setUserid(entry.getUserid());
		
		Entry updateEntry = entryService.updateEntry(entry1);
		
		return updateEntry;	
	}
	
	@PatchMapping("/entries/{id}")
	public Entry updateEntry3(@PathVariable("id") Long id, @RequestBody Entry entry) {
		
		Entry entry1 = entryService.findById(id);
		
		Date dt = entry.getEntryDate();
		String desc = entry.getDescription();
		Long userid = entry.getUserid();
		
		if(dt != null) {
			entry1.setEntryDate(entry.getEntryDate());
		}
		
		if (desc!=null && desc.length()>0) {
			entry1.setDescription(entry.getDescription());
		}
		if(userid>0) {
			entry1.setUserid(entry.getUserid());
		}
		
		Entry updateEntry = entryService.updateEntry(entry1);
		
		return updateEntry;	
	}
	
	
	@GetMapping("/entries/{id}")
	public Entry findById(@PathVariable("id") Long id) {
		return entryService.findById(id);
	}
	
	@DeleteMapping("/entries/{id}")
	public void deleteEntry(@PathVariable("id") Long id) {
		Entry entry = entryService.findById(id);
		entryService.deleteEntry(entry);
	}

}













