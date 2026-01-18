package com.jhansi.roommateportal.controller;

import com.jhansi.roommateportal.model.GroceryItem;
import com.jhansi.roommateportal.service.GroceryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery")
@CrossOrigin(origins = "http://localhost:3000")
public class GroceryController {

    private final GroceryService service;

    public GroceryController(GroceryService service) {
        this.service = service;
    }

    @PostMapping
    public GroceryItem add(@RequestParam String name,
                            @RequestParam boolean needed) {
        return service.addItem(name, needed);
    }

    @GetMapping("/need")
    public List<GroceryItem> getNeed() {
        return service.getNeeded();
    }

    @GetMapping("/have")
    public List<GroceryItem> getHave() {
        return service.getHave();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
