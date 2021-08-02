package edu.vsem.controller.gui;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectGuiController
  @version  1.0.0 
  @since 01.08.2021 - 14.02
*/


import edu.vsem.form.SubjectCreateForm;
import edu.vsem.form.SubjectUpdateForm;
import edu.vsem.model.Subject;
import edu.vsem.service.subject.impls.SubjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gui/subject")
public class SubjectGuiController {

    @Autowired
    SubjectServiceImpl service;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<Subject> subjects = service.getAll();
        model.addAttribute("subjects", subjects);
        return "subjects";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);

        return "redirect:/gui/subject/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        SubjectCreateForm formToCreate = new SubjectCreateForm();
        model.addAttribute("form", formToCreate);
        return "subject-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") SubjectCreateForm form){
        Subject subject = new Subject();
        subject.setName(form.getName());
        subject.setLectureRate(form.getLectureRate());
        subject.setPracticesRate(form.getPracticesRate());
        subject.setLabsRate(form.getLabsRate());
        subject.setDescription(form.getDescription());

        service.create(subject);

        return "redirect:/gui/subject/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        Subject subject = service.get(id);
        SubjectUpdateForm formToUpdate = new SubjectUpdateForm();

        formToUpdate.setId(subject.getId());
        formToUpdate.setName(subject.getName());
        formToUpdate.setLectureRate(subject.getLectureRate());
        formToUpdate.setPracticesRate(subject.getPracticesRate());
        formToUpdate.setLabsRate(subject.getLabsRate());
        formToUpdate.setDescription(subject.getDescription());
        formToUpdate.setCreatedAt(subject.getCreatedAt());
        formToUpdate.setUpdatedAt(subject.getUpdatedAt());

        model.addAttribute("form", formToUpdate);
        return "subject-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") SubjectUpdateForm form){
        Subject subject = new Subject();
        subject.setId(form.getId());
        subject.setName(form.getName());
        subject.setLectureRate(form.getLectureRate());
        subject.setPracticesRate(form.getPracticesRate());
        subject.setLabsRate(form.getLabsRate());
        subject.setDescription(form.getDescription());
        subject.setCreatedAt(form.getCreatedAt());

        service.update(subject);

        return "redirect:/gui/subject/all";
    }
}
