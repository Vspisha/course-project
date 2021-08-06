package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumMongoRepository
  @version  1.0.0 
  @since 05.08.2021 - 21.42
*/

import edu.vsem.model.Item;
import edu.vsem.model.Сurriculum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumMongoRepository extends MongoRepository<Сurriculum,String> {
}
