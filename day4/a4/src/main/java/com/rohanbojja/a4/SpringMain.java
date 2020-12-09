package com.rohanbojja.a4;

import com.rohanbojja.a4.models.Emp;
import com.rohanbojja.a4.repositories.EmpDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        EmpDao rep = context.getBean(EmpDao.class);
//        rep.save(new Emp(1, "Rohan", "Hyderabad", 69000));
//        rep.save(new Emp(2, "Abhinay", "Pune", 62000));
        Emp e = rep.findById(2);
        System.out.println(e.getName());
        List<Emp> eList = rep.list();
        for (Emp ee : eList) {
            System.out.println(ee.id + "\t" + ee.getName() + "\t" + ee.getCity() + "\t" + ee.getSalary());
        }
        Emp e2 = rep.findById(101);
        System.out.println(e2.getName());
    }
}
