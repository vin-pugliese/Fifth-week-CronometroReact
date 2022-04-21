package com.corso.java.controller;

import com.corso.java.domain.TimeRecord;
import com.corso.java.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("timer/api/v1")
public class TimeRecordController {

    @Autowired
    RecordService recordService;

    @Autowired
    MongoOperations mongoOperation;

    @GetMapping
    ResponseEntity<List<TimeRecord>> getAll(){
        List<TimeRecord> records = recordService.findAll();
        return new ResponseEntity<>(records, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<TimeRecord> findById(@PathVariable String id) {
        Optional<TimeRecord> record = recordService.findById(id);
        return new ResponseEntity<TimeRecord>((TimeRecord) recordService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<TimeRecord> save(@RequestBody TimeRecord record){
        TimeRecord record1 = recordService.create(record);
        return new ResponseEntity<>(record1, HttpStatus.OK);
    }

    @PutMapping
    ResponseEntity<?> update(@RequestParam String id, @RequestParam String finish){
        recordService.update(id, finish);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path="/{id}")
    ResponseEntity<Void> deleteById(@PathVariable String id){
        recordService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
