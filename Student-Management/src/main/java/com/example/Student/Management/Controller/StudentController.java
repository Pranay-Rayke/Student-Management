package com.example.Student.Management.Controller;

import com.example.Student.Management.Entity.Student;
import com.example.Student.Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-management")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return new ResponseEntity<>("Student added successfully",HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam int studentId)
    {
        Student student = studentService.getStudent(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateStudentMobileNo(@RequestParam int studentId, @RequestParam String newMobileNumber)
    {
        Student student = studentService.updateStudentMobileNo(studentId,newMobileNumber);
        return new ResponseEntity<>(student.getName()+" "+"your mobile number update successfully !!",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteStudent(@RequestParam int studentId)
    {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
