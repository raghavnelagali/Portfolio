package com.demo_example.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo_example.entity.Student;

public interface StudentRepository extends CrudRepository<Student,Long>{
	

}
