package com.jhansi.roommateportal.repository;

import com.jhansi.roommateportal.model.GroceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryRepository extends JpaRepository<GroceryItem, Long> {

    List<GroceryItem> findByNeeded(boolean needed);
}
