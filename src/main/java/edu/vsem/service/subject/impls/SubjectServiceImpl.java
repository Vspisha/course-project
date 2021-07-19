package edu.vsem.service.subject.impls;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  SubjectServiceImpl
  @version  1.0.0 
  @since 19.07.2021 - 18.21
*/

import edu.vsem.model.Item;
import edu.vsem.model.Subject;
import edu.vsem.service.subject.interfaces.ISubjectService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class SubjectServiceImpl implements ISubjectService {
    private LocalDateTime time = LocalDateTime.now();
    private List<Subject> list = new ArrayList<>(
            Arrays.asList(
                    new Subject("0","name0", 30, 15, 10,"desc0", time, time ),
                    new Subject("1","name1", 22, 5, 5,"desc1", time, time),
                    new Subject("2","name2", 11, 3, 8,"desc2", time, time),
                    new Subject("3","name3", 14, 8, 9,"desc3", time, time)


            )
    );
    @Override
    public Subject create(Subject subject) {
        return null;
    }

    @Override
    public Subject get(String id) {
        Subject subject = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return subject;
    }

    @Override
    public Subject update(Subject subject) {
        return null;
    }

    @Override
    public Subject delete(String id) {
        Subject subject = this.get(id);
        list.remove(subject);
        return subject;
    }

    @Override
    public List<Subject> getAll() {
        return list;
    }
}
