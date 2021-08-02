package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentCreateForm
  @version  1.0.0 
  @since 02.08.2021 - 16.53
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateForm {
    private String name;
    private String surname;
    private String patronymic;
    private String adress;
    private String telefonNumber;
    private String description;
}
