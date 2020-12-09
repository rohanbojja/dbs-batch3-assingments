package com.rohanbojja.a4.repositories;

import com.rohanbojja.a4.models.Emp;

import java.util.List;

public interface EmpDao {
    String save(Emp e);

    List<Emp> list();

    Emp findById(int id);
}
