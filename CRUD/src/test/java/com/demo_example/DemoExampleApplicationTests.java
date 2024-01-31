package com.demo_example;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo_example.entity.Student;
import com.demo_example.repository.StudentRepository;

@SpringBootTest
class DemoExampleApplicationTests {
	
	@Autowired
	private StudentRepository studentRepo;

	//create
	@Test
	void saveStudentInformation() {
		Student s = new Student();
		s.setName("raghu");
		s.setCourse("java");
		s.setFee(10000);
		studentRepo.save(s);
		
	}
	
	//read
		@Test
		public void findStudentById() {
			Optional<Student> findById = studentRepo.findById(1L);
			if(findById.isPresent()) {
				Student student = findById.get();
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getCourse());
				System.out.println(student.getFee());
			}else {
				System.out.println("no record found");
			}
			
		}
		
		//read all
		@Test
		public void allStudents() {
			Iterable<Student> findAll = studentRepo.findAll();
			for (Student student : findAll) {
				System.out.println(student.getId());
				System.out.println(student.getName());
				System.out.println(student.getCourse());
				System.out.println(student.getFee());
				
			}
		}
		
		//update
		@Test
		void updateStudentInformation() {
			Student s = new Student();
			s.setId(1);
			s.setName("raghu");
			s.setCourse("java");
			s.setFee(10000);
			studentRepo.save(s);

	}
		
	
	//delete
	@Test
	void deleteStudentById() {
		studentRepo.deleteById(1l);
	}
	
	
	
	
	
}
