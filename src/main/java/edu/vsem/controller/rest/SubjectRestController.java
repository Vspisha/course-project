package edu.vsem.controller.rest;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectRestController
  @version  1.0.0 
  @since 19.07.2021 - 17.55
*/

import edu.vsem.model.Item;
import edu.vsem.model.Subject;
import edu.vsem.service.subject.impls.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/subject")
public class SubjectRestController {

    @Autowired
    SubjectServiceImpl service;

    @RequestMapping("/all")
    public List<Subject> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Subject get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Subject delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Subject create(@RequestBody Subject subject){
        return service.create(subject);
    }

    @PostMapping("/update")
    public Subject update(@RequestBody Subject subject){
        return service.update(subject);
    }

}
