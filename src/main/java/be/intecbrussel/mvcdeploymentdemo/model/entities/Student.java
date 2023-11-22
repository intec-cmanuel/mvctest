package be.intecbrussel.mvcdeploymentdemo.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    private Long studentId;
    private String firstName;
    private String lastName;
    
    @OneToMany
    private List<Test> tests;
    
    public Student(String firstName, String lastName, Long studentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        tests = new ArrayList<>();
    }
    
    public Student(){}

    public List<Test> getTests() {
        return tests;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}