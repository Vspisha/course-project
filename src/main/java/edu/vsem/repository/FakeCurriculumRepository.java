package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  FakeCurriculumRepository
  @version  1.0.0 
  @since 05.08.2021 - 21.44
*/

import edu.vsem.model.Student;
import edu.vsem.model.Subject;
import edu.vsem.model.Сurriculum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeCurriculumRepository {
    @Autowired
    StudentMongoRepository studentMongoRepository;
    @Autowired
    SubjectMongoRepository subjectMongoRepository;



    private LocalDateTime time = LocalDateTime.now();
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student("0","name0", "surname0", "patronymic0",
                            "adress0","0950950950950","desc0", time, time ),
                    new Student("1","name1", "surname1", "patronymic1",
                            "adress0","0950950950950","desc1", time, time ),
                    new Student("2","name2", "surname2", "patronymic2",
                            "adress0","0950950950950","desc2", time, time ),
                    new Student("3","name3", "surname3", "patronymic3",
                            "adress0","0950950950950","desc3", time, time )
            )
    );
    private List<Subject> subjects = new ArrayList<>(
            Arrays.asList(
                    new Subject("0","name0", 30, 15, 10,"desc0", time, time ),
                    new Subject("1","name1", 22, 5, 5,"desc1", time, time),
                    new Subject("2","name2", 11, 3, 8,"desc2", time, time),
                    new Subject("3","name3", 14, 8, 9,"desc3", time, time)


            )
    );
    private List<Сurriculum> list = new ArrayList<>(
            Arrays.asList(
                    new Сurriculum("0","name0", students.get(0) ,subjects.get(0) ,45,"desc0", time, time ),
                    new Сurriculum("1","name1",students.get(1) ,subjects.get(1),44,"desc1", time, time ),
                    new Сurriculum("2","name2",students.get(2) ,subjects.get(2),33,"desc2",time, time ),
                    new Сurriculum("3","name3", students.get(3) ,subjects.get(3),22,"desc3", time, time )
            )
    );


    public Сurriculum create(Сurriculum curriculum) {
        String id = UUID.randomUUID().toString();
        curriculum.setId(id);
        curriculum.setCreatedAt(LocalDateTime.now());
        curriculum.setUpdatedAt(LocalDateTime.now());
        list.add(curriculum);
        return curriculum;
    }


    public Сurriculum get(String id) {
        Сurriculum curriculum = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return curriculum;
    }


    public Сurriculum update(Сurriculum curriculum) {
        String id = curriculum.getId();
        Сurriculum сurriculumToUpdate = this.get(id);
        curriculum.setCreatedAt(сurriculumToUpdate.getCreatedAt());
        int index = list.indexOf(сurriculumToUpdate);
        curriculum.setUpdatedAt(LocalDateTime.now());
        list.remove(сurriculumToUpdate);
        list.add(index, curriculum);

        return curriculum;
    }


    public Сurriculum delete(String id) {

        Сurriculum curriculum =  this.get(id);
        list.remove(curriculum);

        return curriculum;
    }


    public List<Сurriculum> getAll() {
        return list;
    }
}
