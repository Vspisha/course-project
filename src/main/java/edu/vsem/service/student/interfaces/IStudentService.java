package edu.vsem.service.student.interfaces;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  IStudentService
  @version  1.0.0 
  @since 02.08.2021 - 15.25
*/

import edu.vsem.model.Student;


import java.util.List;

public interface IStudentService {
    //CRUD
    Student create(Student student);
    Student get(String id);
    Student update(Student student);
    Student delete(String id);
    List<Student> getAll();

}
