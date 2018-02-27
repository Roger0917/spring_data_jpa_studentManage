package com.biz.service.impl;

import com.biz.model.Student;
import com.biz.model.Subject;
import com.biz.repository.SubjectJpaRepository;
import com.biz.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectJpaRepository subjectJpaRepository;

    @Override
    public List<Subject> findAll() {
        return subjectJpaRepository.findAll();
    }

    @Override
    public void saveSubject(Subject subject) {
        subjectJpaRepository.save(subject);
    }

    @Override
    public Subject findOne(long sid) {
        return subjectJpaRepository.findOne(sid);
    }

    @Override
    public void delete(long sid) {
        subjectJpaRepository.delete(sid);
    }

    @Override
    public Subject findByName(String name) {
        return subjectJpaRepository.findByName(name);
    }

    @Override
    public Page<Subject> pageSubject(Pageable pageable) {
        Page<Subject> page = subjectJpaRepository.findAll(pageable);
        return page;
    }
}
