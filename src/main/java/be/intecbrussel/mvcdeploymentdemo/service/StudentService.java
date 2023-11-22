package be.intecbrussel.mvcdeploymentdemo.service;

import be.intecbrussel.mvcdeploymentdemo.model.entities.Student;
import be.intecbrussel.mvcdeploymentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository sr;
    
    public Optional<Student> getStudent(Long studentId) {
        return sr.findById(studentId);
    }
    
    public void addStudent(Student student) {
        sr.save(student);
    }
    
    public List<Student> getAllStudents() {
        return sr.findAll();
    }
}