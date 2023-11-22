package be.intecbrussel.mvcdeploymentdemo.repository;

import be.intecbrussel.mvcdeploymentdemo.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}