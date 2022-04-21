package com.corso.java.domain;

import lombok.*;
import org.bson.BsonDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Document(collection = "records")
public class TimeRecord {

    @Id
    private String id;

    private String nome;
    private String lastName;
    private String timeStart;
    private String timeFinish;
}
