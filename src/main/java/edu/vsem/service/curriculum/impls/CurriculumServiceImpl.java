package edu.vsem.service.curriculum.impls;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  CurriculumServiceImpl
  @version  1.0.0 
  @since 05.08.2021 - 21.36
*/


import edu.vsem.model.Сurriculum;
import edu.vsem.repository.CurriculumMongoRepository;
import edu.vsem.repository.FakeCurriculumRepository;
import edu.vsem.service.curriculum.interfaces.ICurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurriculumServiceImpl implements ICurriculumService {
    @Autowired
    FakeCurriculumRepository repository;

    @Autowired
    CurriculumMongoRepository mongoRepository;
    @PostConstruct
    void init(){
        List<Сurriculum> list = repository.getAll();
        mongoRepository.saveAll(list);
    }
    @Override
    public Сurriculum create(Сurriculum curriculum) {
        curriculum.setCreatedAt(LocalDateTime.now());
        curriculum.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(curriculum);
    }

    @Override
    public Сurriculum get(String id) {
        return mongoRepository.findById(id).get();
    }

    @Override
    public Сurriculum update(Сurriculum curriculum) {
        Сurriculum curriculumToUpdate = this.get(curriculum.getId());
        LocalDateTime creation = curriculumToUpdate.getCreatedAt();
        curriculum.setCreatedAt(creation);
        curriculum.setUpdatedAt(LocalDateTime.now());
        return mongoRepository.save(curriculum);
    }

    @Override
    public Сurriculum delete(String id) {
        Сurriculum curriculum = this.get(id);
        mongoRepository.deleteById(id);
        return curriculum;
    }

    @Override
    public List<Сurriculum> getAll() {
        return mongoRepository.findAll();
    }
}
