package com.example.Student.Management.Service;

import com.example.Student.Management.Entity.Student;

public interface StudentService {

    public void addStudent(Student student);

    public Student getStudent(int studentId);

    public Student updateStudentMobileNo(int studentId, String mobileNo);

    public void deleteStudent(int studentId);

}
