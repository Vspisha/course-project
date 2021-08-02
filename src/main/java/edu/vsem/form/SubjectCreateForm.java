package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectCreateForm
  @version  1.0.0 
  @since 01.08.2021 - 14.18
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateForm {
    private String name;
    private double lectureRate;
    private double practicesRate;
    private double labsRate;
    private String description;
}
