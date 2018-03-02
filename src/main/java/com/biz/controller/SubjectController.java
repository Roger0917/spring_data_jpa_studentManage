package com.biz.controller;

import com.biz.model.Grade;
import com.biz.model.Subject;
import com.biz.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @RequestMapping(value = "/toAddSubject.action")
    public ModelAndView toAddSubject(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addsubject");
        return modelAndView;
    }

    @RequestMapping(value = /*"/add/{name}"*/"/addSubject.action")
    public ModelAndView addSubject(@RequestParam String name){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = new Subject(name);
        subjectService.saveSubject(subject);
        Pageable pageable = new PageRequest(0,4);
        Page<Subject> page = subjectService.pageSubject(pageable);
        List<Subject> allsubjects = page.getContent();
       // List<Subject> subjectList =  subjectService.findAll();
        modelAndView.addObject("allsubjects",allsubjects);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("listsubject");
        return modelAndView;
    }

    @RequestMapping(value = "/toUpdateSubject.action")
    public ModelAndView toUpdateSubject(@RequestParam Integer sid){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = subjectService.findOne(sid);
        modelAndView.addObject("subject",subject);
        modelAndView.setViewName("updatesubject");
        return modelAndView;
    }

    @RequestMapping(value = "/updateSubject.action")
    public ModelAndView updateSubject(@RequestParam  Integer sid,@RequestParam String sname){
        ModelAndView modelAndView = new ModelAndView();
        Subject subject = subjectService.findOne(sid);
        subject.setName(sname);
        subjectService.saveSubject(subject);
        Pageable pageable = new PageRequest(0,4);
        Page<Subject> page = subjectService.pageSubject(pageable);
        List<Subject> subjectList = page.getContent();
        modelAndView.addObject("page",page);
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
