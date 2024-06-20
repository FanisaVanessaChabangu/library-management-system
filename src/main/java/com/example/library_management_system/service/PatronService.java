package com.example.library_management_system.service;

import com.example.library_management_system.model.Patron;
import com.example.library_management_system.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;

    public Patron savePatron(Patron patron) {
        return patronRepository.save(patron);
    }

    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    public Patron getPatronById(Long id) {
        return patronRepository.findById(id).orElse(null);
    }

    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }
}
