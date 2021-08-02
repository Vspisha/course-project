package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  FakeSubjectRepository
  @version  1.0.0 
  @since 01.08.2021 - 14.27
*/

import edu.vsem.model.Subject;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeSubjectRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Subject> list = new ArrayList<>(
            Arrays.asList(
                    new Subject("0","name0", 30, 15, 10,"desc0", time, time ),
                    new Subject("1","name1", 22, 5, 5,"desc1", time, time),
                    new Subject("2","name2", 11, 3, 8,"desc2", time, time),
                    new Subject("3","name3", 14, 8, 9,"desc3", time, time)


            )
    );

    public Subject create(Subject subject) {
        String id = UUID.randomUUID().toString();
        subject.setId(id);
        subject.setCreatedAt(LocalDateTime.now());
        subject.setUpdatedAt(LocalDateTime.now());
        list.add(subject);
        return subject;
    }


    public Subject get(String id) {
        Subject subject = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return subject;
    }


    public Subject update(Subject subject) {
        String id = subject.getId();
        Subject subjectToUpdate = this.get(id);
        subject.setCreatedAt(subjectToUpdate.getCreatedAt());
        int index = list.indexOf(subjectToUpdate);
        subject.setUpdatedAt(LocalDateTime.now());
        list.remove(subjectToUpdate);
        list.add(index, subject);

        return subject;
    }


    public Subject delete(String id) {

        Subject subject =  this.get(id);
        list.remove(subject);

        return subject;
    }


    public List<Subject> getAll() {
        return list;
    }
}

