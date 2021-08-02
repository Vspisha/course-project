package edu.vsem.service.subject.impls;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectServiceImpl
  @version  1.0.0 
  @since 19.07.2021 - 18.21
*/


import edu.vsem.model.Subject;
import edu.vsem.repository.FakeSubjectRepository;
import edu.vsem.repository.SubjectMongoRepository;
import edu.vsem.service.subject.interfaces.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    FakeSubjectRepository repository;

    @Autowired
    SubjectMongoRepository mongoRepository;
    //@PostConstruct
    void init(){
        List<Subject> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Subject create(Subject subject) {
        subject.setCreatedAt(LocalDateTime.now());
        subject.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(subject);
    }

    @Override
    public Subject get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Subject update(Subject subject) {
        Subject subjectToUpdate = this.get(subject.getId());
        LocalDateTime creation = subjectToUpdate.getCreatedAt();
        subject.setCreatedAt(creation);
        subject.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(subject);
    }

    @Override
    public Subject delete(String id) {
        Subject subject = this.get(id);
        mongoRepository.deleteById(id);
        return subject;
    }

    @Override
    public List<Subject> getAll() {
        return mongoRepository.findAll();
    }
}

