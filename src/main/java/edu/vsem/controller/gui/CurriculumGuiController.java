package edu.vsem.controller.gui;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumGuiController
  @version  1.0.0 
  @since 05.08.2021 - 21.54
*/

import edu.vsem.form.CurriculumCreateForm;
import edu.vsem.form.CurriculumUpdateForm;
import edu.vsem.model.Student;
import edu.vsem.model.Subject;
import edu.vsem.model.Сurriculum;
import edu.vsem.repository.StudentMongoRepository;
import edu.vsem.repository.SubjectMongoRepository;
import edu.vsem.service.curriculum.impls.CurriculumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gui/curriculum")
public class CurriculumGuiController {
    @Autowired
    private CurriculumServiceImpl service;

    @Autowired
    private StudentMongoRepository studentMongoRepository;

    @Autowired
    private SubjectMongoRepository subjectMongoRepository;

    @RequestMapping("/all")
    public String getAll(Model model){
        List<CurriculumUpdateForm> curriculums = service.getAll().stream()
                .map(CurriculumUpdateForm::new)
                .collect(Collectors.toList());
        model.addAttribute("curriculums", curriculums);
        return "curriculums";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(Model model, @PathVariable("id") String id){
        service.delete(id);
        return "redirect:/gui/curriculum/all";
    }


    @GetMapping("/create")
    public String create(Model model){
        CurriculumCreateForm formToCreate = new CurriculumCreateForm();
        Map<String, String> studentsMap = getStudentsMap();
        Map<String, String> subjectsMap = getSubjectsMap();
        model.addAttribute("students", studentsMap);
        model.addAttribute("subjects", subjectsMap);
        model.addAttribute("form", formToCreate);
        return "curriculum-create";
    }

    @PostMapping("/create")
    public String create( @ModelAttribute("form") CurriculumCreateForm form){
        Сurriculum curriculum = new Сurriculum();
        Subject subject = subjectMongoRepository.findByName(form.getSubject()).get(0);
        String[] studentData = form.getStudent().split(" ");
        Student student = studentMongoRepository.findByNameAndSurnameAndPatronymic(studentData[0], studentData[1], studentData[2])
                .get(0);
        curriculum.setMark(form.getMark());
        curriculum.setName(form.getName());
        curriculum.setDescription(form.getDescription());
        curriculum.setSubject(subject);
        curriculum.setStudent(student);
        service.create(curriculum);
        return "redirect:/gui/curriculum/all";
    }


    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable("id") String id){
        CurriculumUpdateForm formToUpdate = new CurriculumUpdateForm(service.get(id));
        Map<String, String> subjectsMap = getSubjectsMap();
        Map<String, String> studentsMap = getStudentsMap();
        model.addAttribute("students", studentsMap);
        model.addAttribute("subjects", subjectsMap);
        model.addAttribute("form", formToUpdate);
        return "curriculum-update";
    }

    @PostMapping("/update/{id}")
    public String update( @ModelAttribute("form") CurriculumUpdateForm form, @PathVariable("id") String id){
        Сurriculum сurriculum = service.get(id);
        Subject subject = subjectMongoRepository.findByName(form.getSubject()).get(0);
        String[] studentData = form.getStudent().split(" ");
        Student student = studentMongoRepository.findByNameAndSurnameAndPatronymic(studentData[0], studentData[1], studentData[2])
                .get(0);
        сurriculum.setSubject(subject);
        сurriculum.setStudent(student);
        сurriculum.setName(form.getName());
        сurriculum.setMark(form.getMark());
        сurriculum.setDescription(form.getDescription());
        service.update(сurriculum);
        return "redirect:/gui/curriculum/all";
    }

    private Map<String, String> getSubjectsMap() {
        Map<String, String> subjectsMap = new LinkedHashMap<>();
        List<Subject> subjects = subjectMongoRepository.findAll();
        subjects.stream()
                .map(Subject::getName)
                .forEach(stringName -> subjectsMap.put(stringName, stringName));
        return subjectsMap;
    }

    private Map<String, String> getStudentsMap() {
        Map<String, String> studentsMap = new LinkedHashMap<>();
        List<Student> students = studentMongoRepository.findAll();
        students.stream()
                .map(reader -> reader.getName() + " " + reader.getSurname() + " " + reader.getPatronymic())
                .forEach(stringName -> studentsMap.put(stringName, stringName));
        return studentsMap;
    }
}
