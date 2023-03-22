package com.institutemanagement.restfulapi.Controller;


import com.institutemanagement.restfulapi.Model.Student;
import com.institutemanagement.restfulapi.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/")
public class StudentController {

    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Student getStudent(@PathVariable(name = "id") int id ) {
        return studentService.getAStudent(id);
    }

    @PostMapping
    public Student addAStudent(@RequestBody Student newStudent) {
        studentService.addStudent(newStudent);
        return newStudent;
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student updatedStudent) {
        studentService.updatStudent(updatedStudent);
        return updatedStudent;
    }

//    @DeleteMapping
//    public Student deleteAStudent()
}
