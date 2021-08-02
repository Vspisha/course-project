package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  ItemMongoRepository
  @version  1.0.0 
  @since 23.07.2021 - 09.52
*/

import edu.vsem.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMongoRepository extends MongoRepository<Item,String> {

}
