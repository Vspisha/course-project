package edu.vsem.service.item.interfaces;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  IItemService
  @version  1.0.0 
  @since 18.07.2021 - 19.21
*/

import edu.vsem.model.Item;

import java.util.List;

public interface IItemService {
    //CRUD
    Item create(Item item);
    Item get(String id);
    Item update(Item item);
    Item delete(String id);
    List<Item> getAll();

}
