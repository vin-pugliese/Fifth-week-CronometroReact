package com.corso.java.service;

import com.corso.java.domain.TimeRecord;

import java.util.List;
import java.util.Optional;

public interface RecordService {

    List<TimeRecord> findAll();

    TimeRecord create(TimeRecord record);

    Optional<TimeRecord> findById(String id);

    void update(String id, String finish);

    void delete(String id);
}
