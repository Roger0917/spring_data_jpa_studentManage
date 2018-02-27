package com.biz.repository;

import com.biz.model.Student;
import com.biz.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectJpaRepository extends JpaRepository<Subject,Long>{


    Subject findByName(String name);
}
