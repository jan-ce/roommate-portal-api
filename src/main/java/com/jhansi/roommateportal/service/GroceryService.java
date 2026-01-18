package com.jhansi.roommateportal.service;

import com.jhansi.roommateportal.model.GroceryItem;
import com.jhansi.roommateportal.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository repo;

    public GroceryService(GroceryRepository repo) {
        this.repo = repo;
    }

    public GroceryItem addItem(String name, boolean needed) {
        return repo.save(new GroceryItem(name, needed));
    }

    public List<GroceryItem> getNeeded() {
        return repo.findByNeeded(true);
    }

    public List<GroceryItem> getHave() {
        return repo.findByNeeded(false);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
