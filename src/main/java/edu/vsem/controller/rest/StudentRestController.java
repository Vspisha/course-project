package edu.vsem.controller.rest;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentRestController
  @version  1.0.0 
  @since 02.08.2021 - 16.25
*/

import edu.vsem.model.Student;
import edu.vsem.service.student.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {
    @Autowired
    StudentServiceImpl service;

    @RequestMapping("/all")
    public List<Student> getAll(){
        return service.getAll();
    }
    @RequestMapping("/{id}")
    public Student get(@PathVariable("id")String id){
        return service.get(id);
    }
    @RequestMapping("/delete/{id}")
    public Student delete(@PathVariable("id")String id){
        return service.delete(id);
    }
    @PostMapping("/create")
    public Student create(@RequestBody Student student){
        return service.create(student);
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student){
        return service.update(student);
    }
}
