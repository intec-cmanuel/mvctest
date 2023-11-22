package be.intecbrussel.mvcdeploymentdemo.controller;

import be.intecbrussel.mvcdeploymentdemo.model.entities.Student;
import be.intecbrussel.mvcdeploymentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService ss;
    
    @GetMapping
    public ModelAndView getStudents() {
        List<Student> studentList = ss.getAllStudents();
        ModelAndView mv = new ModelAndView("student.html");
        mv.addObject("students", studentList);
        return mv;
    }
    
    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("newStudent", new Student());
        return "add-student";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute("newStudent") Student newStudent) {
        ss.addStudent(newStudent);
        return "redirect:/";
    }
}