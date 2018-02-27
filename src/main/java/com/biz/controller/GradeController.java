package com.biz.controller;


import com.biz.model.Grade;
import com.biz.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
/*@RequestMapping(value= "/grade")*/
public class GradeController {

    @Autowired
    private IGradeService gradeService;



    @RequestMapping(value = /*"/add/{gname}"*/"/addGradeByName.action")
    public Grade addGradeByName(@PathVariable String gname){
        Grade grade = new Grade(gname);
        gradeService.saveGrade(grade);
        return grade;
    }

    @RequestMapping(value = /*"/update/{goldname}/{gnewname}"*/"/updateGradeByName.action")
    public Grade updateGradeByName(@PathVariable String goldname,@PathVariable String gnewname){
        Grade grade = gradeService.findByName(goldname);
        grade.setName(gnewname);
        gradeService.saveGrade(grade);
        return grade;
    }

    @RequestMapping(value= /*"/delete/{gid}"*/"/deleteGradeById.action")
    public void deleteGradeById(@PathVariable long gid){
        gradeService.delete(gid);
    }

    @RequestMapping(value = /*"/allStudent"*/"/getAllGrades.action")
    public List<Grade> getAllGrades(){
        return gradeService.findAll();
    }

    @RequestMapping(value = /*"/{gid}"*/"/getGradeById.action")
    public Grade getGradeById(@PathVariable int gid){
        return gradeService.findOne(gid);
    }

    @RequestMapping(value = /*"/search/{name}"*/"/getGradeByName.action")
    public Grade getGradeByName(@PathVariable String name){
        return gradeService.findByName(name);
    }
}
