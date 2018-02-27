package com.biz.service;

import com.biz.model.Grade;
import com.biz.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGradeService {

    public List<Grade> findAll();

    public void saveGrade(Grade Grade);

    public Grade findOne(long sid);

    public void delete(long sid);

    public Grade findByName(String name);

    public Page<Grade> pageGrade(Pageable pageable);
}
