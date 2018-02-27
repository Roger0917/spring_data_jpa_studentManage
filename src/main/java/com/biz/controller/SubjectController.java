package com.biz.controller;

import com.biz.model.Grade;
import com.biz.model.Subject;
import com.biz.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @RequestMapping(value = /*"/add/{name}"*/"/addSubject.action")
    public Subject addSubject(@PathVariable String name){
        Subject subject = new Subject(name);
        subjectService.saveSubject(subject);
        return subject;
    }

    @RequestMapping(value = "/update/{soldname}/{snewname}")
    public ModelAndView updateSubject(@PathVariable String soldname, @PathVariable String snewname){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = subjectService.findByName(soldname);
        subject.setName(snewname);
        subjectService.saveSubject(subject);
        List<Subject> subjectList =  subjectService.findAll();
        modelAndView.addObject("allsubjects",subjectList);
        modelAndView.setViewName("listsubject");
        return modelAndView;
    }

    @RequestMapping(value = /*"/delete/{sid}"*/"/deleteSubjectById.action")
    public void deleteSubject(@PathVariable long sid){
        subjectService.delete(sid);
    }

    @RequestMapping(value = "/getSubjects.action")
    public List<Subject> getSubjects(){
        return subjectService.findAll();
    }

    @RequestMapping(value = /*"/{id}"*/"/getSubjectById.action")
    public Subject getSubjectById(@PathVariable int id){
        return subjectService.findOne(id);
    }

    @RequestMapping(value = /*"/search/{name}"*/"/getSubjectByName.action")
    public Subject getSubjectByName(@PathVariable String name){
        return subjectService.findByName(name);
    }
}
