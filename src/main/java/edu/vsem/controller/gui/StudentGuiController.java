package edu.vsem.controller.gui;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentGuiController
  @version  1.0.0 
  @since 02.08.2021 - 16.30
*/

import edu.vsem.form.StudentCreateForm;
import edu.vsem.form.StudentUpdateForm;
import edu.vsem.model.Student;
import edu.vsem.service.student.impls.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/student")
public class StudentGuiController {

    @Autowired
    StudentServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Student> students = service.getAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);

        return "redirect:/gui/student/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        StudentCreateForm formToCreate = new StudentCreateForm();
        model.addAttribute("form", formToCreate);
        return "student-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") StudentCreateForm form){
        Student student = new Student();
        student.setName(form.getName());
        student.setSurname(form.getSurname());
        student.setPatronymic(form.getPatronymic());
        student.setAdress(form.getAdress());
        student.setTelefonNumber(form.getTelefonNumber());
        student.setDescription(form.getDescription());

        service.create(student);

        return "redirect:/gui/student/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Student student = service.get(id);
        StudentUpdateForm formToUpdate = new StudentUpdateForm();

        formToUpdate.setId(student.getId());
        formToUpdate.setName(student.getName());
        formToUpdate.setSurname(student.getSurname());
        formToUpdate.setPatronymic(student.getPatronymic());
        formToUpdate.setAdress(student.getAdress());
        formToUpdate.setTelefonNumber(student.getTelefonNumber());
        formToUpdate.setDescription(student.getDescription());
        formToUpdate.setCreatedAt(student.getCreatedAt());
        formToUpdate.setUpdatedAt(student.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "student-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") StudentUpdateForm form){
        Student student = new Student();
        student.setId(form.getId());
        student.setName(form.getName());
        student.setSurname(form.getSurname());
        student.setPatronymic(form.getPatronymic());
        student.setAdress(form.getAdress());
        student.setTelefonNumber(form.getTelefonNumber());
        student.setDescription(form.getDescription());
        student.setCreatedAt(form.getCreatedAt());

        service.update(student);

        return "redirect:/gui/student/all";
    }
}
