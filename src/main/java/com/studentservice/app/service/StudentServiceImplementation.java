package com.studentservice.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentservice.app.dtos.StuDTO;
import com.studentservice.app.dtos.StudentDTO;
import com.studentservice.app.entity.Student;
import com.studentservice.app.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student addStudent(StudentDTO studentDTO) {
		System.out.println("Adding New Student");
		
		if (studentDTO.getAge() == null || studentDTO.getAge().isEmpty() || studentDTO.getDepartment() == null || studentDTO.getDepartment().isEmpty() || studentDTO.getEmail() == null || 
				studentDTO.getEmail().isEmpty() || studentDTO.getFirstName() == null || studentDTO.getFirstName().isEmpty() || studentDTO.getLastName() == null 
				|| studentDTO.getLastName().isEmpty() || studentDTO.getMatricNumber() == null || studentDTO.getMatricNumber().isEmpty() || studentDTO.getGender() == null || studentDTO.getGender().isEmpty()
				|| studentDTO.getLevel() == null || studentDTO.getLevel().isEmpty() || studentDTO.getPhoneNumber() == null || studentDTO.getPhoneNumber().isEmpty()) {
				return new Student();
			}
		
		Student student = new Student();
		student.setAge(studentDTO.getAge());
		student.setDepartment(studentDTO.getDepartment());
		student.setEmail(studentDTO.getEmail());
		student.setFirstName(studentDTO.getFirstName());
		student.setGender(studentDTO.getGender());
		student.setLastName(studentDTO.getLastName());
		student.setLevel(studentDTO.getLevel());
		student.setMatricNumber(studentDTO.getMatricNumber());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
	
		
		studentRepository.save(student);
		return student;
	}

	@Override
	public Student updateStudent(Student student) {
		System.out.println("Updating Student");
		 
		if (student.getAge() == null || student.getAge().isEmpty() || student.getDepartment() == null || student.getDepartment().isEmpty() || student.getEmail() == null || 
			student.getEmail().isEmpty() || student.getFirstName() == null || student.getFirstName().isEmpty() || student.getLastName() == null 
			|| student.getLastName().isEmpty() || student.getMatricNumber() == null || student.getMatricNumber().isEmpty() || student.getGender() == null || student.getGender().isEmpty()
			|| student.getLevel() == null || student.getLevel().isEmpty() || student.getPhoneNumber() == null || student.getPhoneNumber().isEmpty() || student.getId() == 0) {
			return new Student();
		}
		Optional<Student> isStudent = studentRepository.findById(student.getId());
		if (isStudent.isPresent()) {
			
			isStudent.get().setAge(student.getAge());
			isStudent.get().setDepartment(student.getDepartment());
			isStudent.get().setEmail(student.getEmail());
			isStudent.get().setFirstName(student.getFirstName());
			isStudent.get().setGender(student.getGender());
			isStudent.get().setId(student.getId());
			isStudent.get().setLastName(student.getLastName());
			isStudent.get().setLevel(student.getLevel());
			isStudent.get().setMatricNumber(student.getMatricNumber());
			isStudent.get().setPhoneNumber(student.getPhoneNumber());
			studentRepository.save(student);
			return student;
		}
		
		return new Student();
	}

	@Override
	public Student getStudent(int id) {
		
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public int deleteStudent(int ID) {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findById(ID);
		if (student.isPresent()) {
			studentRepository.delete(student.get());
			return 1;
		}
		return 0;
	}

	@Override
	public Student updateFirstName(int userID,  StuDTO stud) {
		System.out.println("Updating User FirstName by "+stud.getFirstName());
		
		Optional<Student> student = studentRepository.findById(userID);
		if (student.isPresent()) {
			student.get().setFirstName(stud.getFirstName());
			return student.get();
		}
		return null;
	}

}
