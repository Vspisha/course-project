package edu.vsem.model;/*
  @author   Radyslav Churkin
  @project   SSProgect
  @class  Subjects
  @version  1.0.0 
  @since 18.07.2021 - 15.56
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Subject {
    @Id
    private String id;
    private String name;
    private double lectureRate;
    private double practicesRate;
    private double labsRate;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Subject(String name, double lectureRate,
                   double practicesRate, double labsRate, String description) {
        this.name = name;
        this.lectureRate = lectureRate;
        this.practicesRate = practicesRate;
        this.labsRate = labsRate;
        this.description = description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subjects = (Subject) o;
        return id.equals(subjects.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
