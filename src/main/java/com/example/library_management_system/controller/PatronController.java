package com.example.library_management_system.controller;

import com.example.library_management_system.model.Patron;
import com.example.library_management_system.service.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patrons")
public class PatronController {
    @Autowired
    private PatronService patronService;

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        patron.setId(null);  // ensure id is null before creation
        return patronService.savePatron(patron);
    }

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronService.getAllPatrons();
    }

    @GetMapping("/{id}")
    public Patron getPatronById(@PathVariable Long id) {
        return patronService.getPatronById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
    }
}
