package com.university.cli.entities;

import com.university.cli.CRUDRepository;
import com.university.cli.exceptions.DuplicateIdException;
import com.university.cli.exceptions.EntityNotFoundException;
import com.university.evaluation.Evaluation;

import java.util.HashMap;
import java.util.Map;

public class CrudEvaluation implements CRUDRepository<Evaluation> {
    private static HashMap<Integer,Evaluation> evaluations = new HashMap<>();

    @Override
    public void create(Evaluation entity) throws DuplicateIdException {
        if (evaluations.containsKey(entity.getId())) {
            throw new DuplicateIdException();
        }
        evaluations.put(entity.getId(), entity);
    }

    @Override
    public Evaluation read(int id) throws EntityNotFoundException {
        if (evaluations.containsKey(id)){
            return evaluations.get(id);
        }
        else{
            throw new EntityNotFoundException();
        }

    }

    @Override
    public void update(int id, Evaluation entity) throws EntityNotFoundException {
        if (evaluations.containsKey(id)){
            evaluations.put(id, entity);
        }
        else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(int id) {
        if (evaluations.containsKey(id)) {
            evaluations.remove(id);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public String getIdentifier() {
        return "Evaluation";
    }

    @Override
    public Class<Evaluation> getEntityClass() {
        return Evaluation.class;
    }

    public HashMap<Integer, Evaluation> getMap() {
        return evaluations;
    }
}
