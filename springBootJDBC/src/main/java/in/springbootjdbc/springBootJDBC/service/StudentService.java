package in.springbootjdbc.springBootJDBC.service;

import in.springbootjdbc.springBootJDBC.model.Student;
import in.springbootjdbc.springBootJDBC.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }
    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s) {
        repo.save(s);
    }
}
