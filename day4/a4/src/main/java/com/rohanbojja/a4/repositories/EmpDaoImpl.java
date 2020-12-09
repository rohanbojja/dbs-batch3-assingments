package com.rohanbojja.a4.repositories;

import com.rohanbojja.a4.models.Emp;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmpDaoImpl implements EmpDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public String save(Emp e) {
        entityManager.persist(e);
        System.out.println("Employee with ID: " + e.getId() + " saved.");
        return "Employee with ID: " + e.getId() + " saved.";
    }

    @Override
    public List<Emp> list() {
        return entityManager.createQuery("Select t from " + Emp.class.getSimpleName() + " t").getResultList();
    }

    @Override
    public Emp findById(int id) {
        return entityManager.find(Emp.class, id);
    }
}
