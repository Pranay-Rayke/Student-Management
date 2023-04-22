package com.example.Student.Management.Service.Implimentation;

import com.example.Student.Management.Entity.Student;
import com.example.Student.Management.Repository.StudentRepository;
import com.example.Student.Management.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplimentation implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudent(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        return student;
    }

    @Override
    public Student updateStudentMobileNo(int studentId, String newMobileNo) {
        Student student = studentRepository.findById(studentId).get();
        student.setMobileNo(newMobileNo);
        studentRepository.save(student);
        return student;
    }

    @Override
    public void deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
    }
}
