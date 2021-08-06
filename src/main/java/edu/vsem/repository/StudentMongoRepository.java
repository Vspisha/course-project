package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentMongoRepository
  @version  1.0.0 
  @since 02.08.2021 - 16.18
*/

import edu.vsem.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMongoRepository extends MongoRepository<Student,String> {
    List<Student> findByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
