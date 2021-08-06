package edu.vsem.service.curriculum.interfaces;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  ICurriculumService
  @version  1.0.0 
  @since 05.08.2021 - 21.36
*/

import edu.vsem.model.Student;
import edu.vsem.model.Сurriculum;


import java.util.List;

public interface ICurriculumService {
    Сurriculum create(Сurriculum curriculum);
    Сurriculum get(String id);
    Сurriculum update(Сurriculum curriculum);
    Сurriculum delete(String id);
    List<Сurriculum> getAll();

}
