package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectMongoRepository
  @version  1.0.0 
  @since 01.08.2021 - 14.32
*/


import edu.vsem.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectMongoRepository extends MongoRepository<Subject,String> {
    List<Subject> findByName(String name);
}