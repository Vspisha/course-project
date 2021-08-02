package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentUprateForm
  @version  1.0.0 
  @since 02.08.2021 - 16.54
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentUpdateForm {
    private String id;
    private String name;
    private String surname;
    private String patronymic;
    private String adress;
    private String telefonNumber;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
