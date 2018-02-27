package com.biz.service;

import com.biz.model.Student;
import com.biz.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISubjectService {

    public List<Subject> findAll();

    public void saveSubject(Subject Subject);

    public Subject findOne(long sid);

    public void delete(long sid);

    public Subject findByName(String name);

    public Page<Subject> pageSubject(Pageable pageable);
}
