package edu.vsem.service.subject.interfaces;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  ISubjectService
  @version  1.0.0 
  @since 19.07.2021 - 17.59
*/

import edu.vsem.model.Item;
import edu.vsem.model.Subject;

import java.util.List;

public interface ISubjectService {
    //CRUD
    Subject create(Subject subject);
    Subject get(String id);
    Subject update(Subject subject);
    Subject delete(String id);
    List<Subject> getAll();

}
