package com.university.cli.entities;

import com.university.cli.CRUDRepository;
import com.university.cli.exceptions.DuplicateIdException;
import com.university.cli.exceptions.EntityNotFoundException;
import com.university.course.Course;

import java.util.HashMap;
import java.util.Map;

public class CrudCourse implements CRUDRepository<Course> {
    private static HashMap<Integer, Course> courses = new HashMap<>();

    @Override
    public void create(Course entity) throws DuplicateIdException {
        if (courses.containsKey(entity.getId())) {
            throw new DuplicateIdException();
        }
        courses.put(entity.getId(), entity);
    }

    @Override
    public Course read(int id) throws EntityNotFoundException {
        if (courses.containsKey(id)) {
            return courses.get(id);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void update(int id, Course entity) throws EntityNotFoundException {
        if (courses.containsKey(id)) {
            courses.put(id, entity);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(int id) {
        if (courses.containsKey(id)) {
            courses.remove(id);
        }
        else{
            throw new EntityNotFoundException();
        }

    }

    @Override
    public String getIdentifier() {
        return "Course";
    }

    @Override
    public Class<Course> getEntityClass() {
        return Course.class;
    }

    public HashMap<Integer, Course> getMap(){
        return courses;
    }
}
