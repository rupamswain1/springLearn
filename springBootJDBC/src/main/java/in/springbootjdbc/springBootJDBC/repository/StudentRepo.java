package in.springbootjdbc.springBootJDBC.repository;

import in.springbootjdbc.springBootJDBC.model.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
    public void save(Student s) {
        System.out.println("added");
    }
}
