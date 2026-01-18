package com.jhansi.roommateportal.model;

import jakarta.persistence.*;

@Entity
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean needed; // true = need, false = have

    public GroceryItem() {}

    public GroceryItem(String name, boolean needed) {
        this.name = name;
        this.needed = needed;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isNeeded() { return needed; }

    public void setNeeded(boolean needed) { this.needed = needed; }
}
