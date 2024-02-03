package com.diary.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diary.api.entities.Entry;
import com.diary.api.repository.EntryRepository;

@Service
public class EntryServiceImpl implements EntryService{
	
	@Autowired
	private EntryRepository entryRepository;

	@Override
	public Entry saveEntry(Entry entry) {
		// TODO Auto-generated method stub
		return entryRepository.save(entry);
	}

	@Override
	public Entry updateEntry(Entry entry) {
		// TODO Auto-generated method stub
		return entryRepository.save(entry);
	}

	@Override
	public void deleteEntry(Entry entry) {
		// TODO Auto-generated method stub
		entryRepository.delete(entry);
			
		
	}

	@Override
	public Entry findById(Long id) {
		// TODO Auto-generated method stub
		
		return entryRepository.findById(id).get();
		
	}

	@Override
	public List<Entry> findAll() {
		// TODO Auto-generated method stub
		return entryRepository.findAll();
	}

	@Override
	public List<Entry> findByUserId(Long id) {
		// TODO Auto-generated method stub
		return entryRepository.findByUserid(id);
	}

}





