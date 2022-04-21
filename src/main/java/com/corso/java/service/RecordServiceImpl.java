package com.corso.java.service;

import com.corso.java.Repository.RecordRepository;
import com.corso.java.domain.TimeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    RecordRepository recordRepository;

    @Override
    public List<TimeRecord> findAll() {
        return recordRepository.findAll();
    }

    @Override
    public TimeRecord create(TimeRecord record) {
        return recordRepository.save(record);
    }

    @Override
    public Optional<TimeRecord> findById(String id) {
        return recordRepository.findById(id);
    }

    @Override
    public void update(String id, String finish) {
        Optional<TimeRecord> x = recordRepository.findById(id);
        x.ifPresent(s ->{
            s.setTimeFinish(finish);
            recordRepository.save(s);
        });
    }

    @Override
    public void delete(String id) {
       recordRepository.deleteById(id);
        System.out.println("Eliminato record: " +id);
    }
}
