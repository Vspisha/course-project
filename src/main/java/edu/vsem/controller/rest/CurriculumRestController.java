package edu.vsem.controller.rest;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumRestController
  @version  1.0.0 
  @since 05.08.2021 - 21.32
*/

import edu.vsem.model.Сurriculum;
import edu.vsem.service.curriculum.impls.CurriculumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curriculum")
public class CurriculumRestController {
    @Autowired
    CurriculumServiceImpl service;

    @RequestMapping("/all")
    public List<Сurriculum> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Сurriculum get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Сurriculum delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Сurriculum create(@RequestBody Сurriculum curriculum){
        return service.create(curriculum);
    }

    @PostMapping("/update")
    public Сurriculum update(@RequestBody Сurriculum curriculum){
        return service.update(curriculum);
    }
}
