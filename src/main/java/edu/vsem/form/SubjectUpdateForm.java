package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectUpdateForm
  @version  1.0.0 
  @since 01.08.2021 - 14.19
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectUpdateForm {
    private String id;
    private String name;
    private double lectureRate;
    private double practicesRate;
    private double labsRate;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
