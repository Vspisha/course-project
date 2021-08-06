package edu.vsem.form;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumUpdateForm
  @version  1.0.0 
  @since 05.08.2021 - 23.06
*/


import edu.vsem.model.Сurriculum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurriculumUpdateForm {
    private String id;
    private String name;
    private String student;
    private String subject;
    private int mark;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CurriculumUpdateForm(Сurriculum curriculum) {
        this.id = curriculum.getId();
        this.name = curriculum.getName();
        this.student = curriculum.getStudent().getName() + " " +curriculum.getStudent().getSurname() + " "
                + curriculum.getStudent().getPatronymic() ;
        this.subject = curriculum.getSubject().getName();
        this.mark = curriculum.getMark();
        this.description = curriculum.getDescription();
        this.createdAt = curriculum.getCreatedAt();
        this.updatedAt = curriculum.getUpdatedAt();
    }
}
