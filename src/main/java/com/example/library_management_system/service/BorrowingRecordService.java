package com.example.library_management_system.service;

import com.example.library_management_system.model.BorrowingRecord;
import com.example.library_management_system.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public BorrowingRecord createBorrowingRecord(Long bookId, Long patronId) {
        BorrowingRecord record = new BorrowingRecord();
        record.setBookId(bookId);
        record.setPatronId(patronId);
        record.setBorrowDate(LocalDate.now());

        return borrowingRecordRepository.save(record);
    }

    public Optional<BorrowingRecord> getBorrowingRecord(Long bookId, Long patronId) {
        return borrowingRecordRepository.findByBookIdAndPatronId(bookId, patronId);
    }
}
