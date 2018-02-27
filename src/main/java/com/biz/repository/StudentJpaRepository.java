package com.biz.repository;

import com.biz.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student,Long>{

    List<Student> findByName(String name);
    Student findBySid(String sid);

}
