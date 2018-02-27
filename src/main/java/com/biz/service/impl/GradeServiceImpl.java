package com.biz.service.impl;

import com.biz.model.Grade;
import com.biz.model.Student;
import com.biz.repository.GradeJpaRepository;
import com.biz.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GradeServiceImpl implements IGradeService {

    @Autowired
    private GradeJpaRepository GradeJpaRepository;
    
    @Override
    public List<Grade> findAll() {
        return GradeJpaRepository.findAll();
    }

    @Override
    public void saveGrade(Grade grade) {
        GradeJpaRepository.save(grade);
    }

    @Override
    public Grade findOne(long gid) {
        return GradeJpaRepository.findOne(gid);
    }

    @Override
    public void delete(long gid) {
        GradeJpaRepository.delete(gid);
    }

    @Override
    public Grade findByName(String name) {
        return GradeJpaRepository.findByName(name);
    }

    @Override
    public Page<Grade> pageGrade(Pageable pageable){
        Page<Grade> page = GradeJpaRepository.findAll(pageable);
        return page;
    };
}
