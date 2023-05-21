package com.orient.springthyme99.repository;

import com.orient.springthyme99.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
