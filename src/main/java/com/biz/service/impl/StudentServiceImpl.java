package com.biz.service.impl;


import com.biz.model.Student;
import com.biz.repository.StudentJpaRepository;
import com.biz.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentJpaRepository studentJpaRepository;


    @Override
    public List<Student> findAll() {
        return studentJpaRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        studentJpaRepository.save(student);
    }

    @Override
    public Student findOne(long sid) {
        return studentJpaRepository.findOne(sid);
    }

    @Override
    public void delete(long sid) {
        studentJpaRepository.delete(sid);
    }

    @Override
    public List<Student> findByName(String name) {
        return studentJpaRepository.findByName(name);
    }

    @Override
    public Page pageStudent(Pageable pageable) {
        //Pageable pageable1 = new PageRequest(0,5);
        Page<Student> page = studentJpaRepository.findAll(pageable);
        return page;
    }
}
