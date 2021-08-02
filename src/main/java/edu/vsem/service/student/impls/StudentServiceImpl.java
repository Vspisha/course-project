package edu.vsem.service.student.impls;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  StudentServiceImpl
  @version  1.0.0 
  @since 02.08.2021 - 15.25
*/

import edu.vsem.model.Student;
import edu.vsem.repository.FakeStudentRepository;
import edu.vsem.repository.StudentMongoRepository;
import edu.vsem.service.student.interfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    FakeStudentRepository repository;

    @Autowired
    StudentMongoRepository mongoRepository;
    //@PostConstruct
    void init(){
        List<Student> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Student create(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(student);
    }

    @Override
    public Student get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Student update(Student student) {
        Student studentToUpdate = this.get(student.getId());
        LocalDateTime creation = studentToUpdate.getCreatedAt();
        student.setCreatedAt(creation);
        student.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(student);
    }

    @Override
    public Student delete(String id) {
        Student student = this.get(id);
        mongoRepository.deleteById(id);
        return student;
    }

    @Override
    public List<Student> getAll() {
        return mongoRepository.findAll();
    }
}

