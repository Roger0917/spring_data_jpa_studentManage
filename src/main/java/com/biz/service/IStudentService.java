package com.biz.service;

import com.biz.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {

    public List<Student> findAll();

    public void saveStudent(Student student);

    public Student findOne(long sid);

    public void delete(long sid);

    public List<Student> findByName(String name);

    public Page<Student> pageStudent(Pageable pageable);

}
