package com.university.cli.entities;

import com.university.cli.CRUDRepository;
import com.university.cli.exceptions.DuplicateIdException;
import com.university.cli.exceptions.EntityNotFoundException;
import com.university.student.Student;

import java.util.HashMap;
import java.util.Map;

public class CrudStudent implements CRUDRepository<Student> {
    private static Map<Integer, Student> students = new HashMap<>();
    @Override
    public void create(Student entity) throws DuplicateIdException {
        if (students.containsKey(entity.getId())) {
            throw new DuplicateIdException();
        }
        students.put(entity.getId(), entity);
    }

    @Override
    public Student read(int id) throws EntityNotFoundException {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void update(int id, Student entity) throws EntityNotFoundException {
        if (students.containsKey(id)) {
            students.put(id, entity);
        }
        else{
            throw new EntityNotFoundException();
        }

    }

    @Override
    public void delete(int id) {
        if (students.containsKey(id)) {
            students.remove(id);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public String getIdentifier() {
        return "Student";
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }

    public Map<Integer, Student> getMap(){
        return students;
    }
}
