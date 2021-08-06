package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumCreateForm
  @version  1.0.0 
  @since 05.08.2021 - 23.04
*/

import edu.vsem.model.Student;
import edu.vsem.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumCreateForm {
    private String name;
    private String student;
    private String subject;
    private int mark;
    private String description;
}
