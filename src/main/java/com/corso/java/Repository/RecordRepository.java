package com.corso.java.Repository;

import com.corso.java.domain.TimeRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends MongoRepository<TimeRecord, String> {
}
