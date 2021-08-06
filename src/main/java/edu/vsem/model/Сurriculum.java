package edu.vsem.model;/*
  @author   Radyslav Churkin
  @project   SSProgect
  @class  Сurriculum
  @version  1.0.0 
  @since 18.07.2021 - 16.02
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
public class Сurriculum {
    @Id
    private String id;
    private String name;
    private Student student;
    private Subject subject;
    private int mark;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Сurriculum(String name, Student student, Subject subject, int mark, String description) {
        this.name = name;
        this.student = student;
        this.subject = subject;
        this.mark = mark;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Сurriculum that = (Сurriculum) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
