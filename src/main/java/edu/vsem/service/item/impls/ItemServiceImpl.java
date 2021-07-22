package edu.vsem.service.item.impls;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  ItemServiceImpl
  @version  1.0.0 
  @since 18.07.2021 - 19.27
*/

import edu.vsem.model.Item;
import edu.vsem.repository.FakeItemRepository;
import edu.vsem.service.item.interfaces.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ItemServiceImpl implements IItemService {

    @Autowired
    FakeItemRepository repository;

    @Override
    public Item create(Item item) {
        return repository.create(item);
    }

    @Override
    public Item get(String id) {
        return repository.get(id);
    }

    @Override
    public Item update(Item item) {
        return repository.update(item);
    }

    @Override
    public Item delete(String id) {
        return repository.delete(id);
    }

    @Override
    public List<Item> getAll() {
            return repository.getAll();
    }
}
