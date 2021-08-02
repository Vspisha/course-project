package edu.vsem.model;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  Students
  @version  1.0.0 
  @since 18.07.2021 - 15.50
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
public class Student {
    @Id
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String adress;
    private String telefonNumber;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Student(String name, String surname, String patronymic,
                   String adress, String telefonNumber, String description) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.adress = adress;
        this.telefonNumber = telefonNumber;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student students = (Student) o;
        return id.equals(students.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
