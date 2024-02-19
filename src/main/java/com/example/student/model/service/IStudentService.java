package com.example.student.model.service;

import com.example.student.model.Student;

import java.util.List;

public interface IStudentService {
List<Student> findAll();
void save (Student student);
}
