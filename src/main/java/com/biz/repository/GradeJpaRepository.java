package com.biz.repository;

import com.biz.model.Grade;
import com.biz.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeJpaRepository extends JpaRepository<Grade,Long> {

    Grade findByName(String name);
}
