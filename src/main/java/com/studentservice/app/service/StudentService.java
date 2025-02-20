package com.studentservice.app.service;

import java.util.List;

import com.studentservice.app.dtos.StuDTO;
import com.studentservice.app.dtos.StudentDTO;
import com.studentservice.app.entity.Student;

public interface StudentService {
	Student addStudent(StudentDTO studentDTO);
	Student updateStudent(Student student);
	Student getStudent(int id);
	List<Student> getAllStudents();
	int deleteStudent(int id);
	Student updateFirstName(int userID, StuDTO student);
}
