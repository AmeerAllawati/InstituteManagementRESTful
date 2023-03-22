package com.institutemanagement.restfulapi.Service;

import com.institutemanagement.restfulapi.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentService {

    public List<Student> studentList = new CopyOnWriteArrayList<>();

    public List<Student> getAllStudents() {
        return studentList;
    }

    public Student getAStudent(int id) {
        return studentList.stream().filter(s -> s.id == id).findFirst().get();
    }

    public Student addStudent(Student newStudent) {
        studentList.add(newStudent);
        return newStudent;
    }

    public Student updatStudent(Student updatedStudent) {
        Student foundStudent = getAStudent(updatedStudent.id);
        foundStudent.name = updatedStudent.name;
        foundStudent.email = updatedStudent.email;
        return updatedStudent;
    }

    public Student deleteStudent(int id) {
        Student foundStudent = getAStudent(id);
        studentList.remove(foundStudent);
        return foundStudent;
    }
}
