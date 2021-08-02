package edu.vsem.repository;/*
  @author   Radyslav Churkin
  @project   course-project
  @class  FakeStudentRepository
  @version  1.0.0 
  @since 02.08.2021 - 16.19
*/

import edu.vsem.model.Student;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeStudentRepository {
    private LocalDateTime time = LocalDateTime.now();
    private List<Student> list = new ArrayList<>(
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

    public Student create(Student student) {
        String id = UUID.randomUUID().toString();
        student.setId(id);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        list.add(student);
        return student;
    }


    public Student get(String id) {
        Student student = list.stream().filter(el -> el.getId().equals(id))
                .findAny().get();
        return student;
    }


    public Student update(Student student) {
        String id = student.getId();
        Student studentToUpdate = this.get(id);
        student.setCreatedAt(studentToUpdate.getCreatedAt());
        int index = list.indexOf(studentToUpdate);
        student.setUpdatedAt(LocalDateTime.now());
        list.remove(studentToUpdate);
        list.add(index, student);

        return student;
    }


    public Student delete(String id) {

        Student student =  this.get(id);
        list.remove(student);

        return student;
    }


    public List<Student> getAll() {
        return list;
    }
}

