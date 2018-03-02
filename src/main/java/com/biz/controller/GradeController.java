package com.biz.controller;


import com.biz.model.Grade;
import com.biz.service.IGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.jws.WebParam;
import java.util.List;

@Controller
/*@RequestMapping(value= "/grade")*/
public class GradeController {

    @Autowired
    private IGradeService gradeService;


    @RequestMapping(value = "/toAddGrade.action")
    public ModelAndView toAddGrade(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addgrade");
        return modelAndView;
    }

    @RequestMapping(value = /*"/add/{gname}"*/"/addGradeByName.action")
    public ModelAndView addGradeByName(@RequestParam String gname){
        ModelAndView modelAndView = new ModelAndView();
        Grade grade = new Grade(gname);
        gradeService.saveGrade(grade);
        Pageable pageable = new PageRequest(0,4);
        Page<Grade> page = gradeService.pageGrade(pageable);
        List<Grade> allgrades = page.getContent();
        //int totalpages = page.getTotalPages();

        modelAndView.addObject("allgrades",allgrades);
        modelAndView.addObject("page",page);
        modelAndView.setViewName("listgrade");
        return modelAndView;
    }

    @RequestMapping(value = /*"/update/{goldname}/{gnewname}"*/"/updateGradeByName.action")
    public ModelAndView updateGradeByName(@RequestParam Integer gid,@RequestParam String gname){
        ModelAndView modelAndView = new ModelAndView();
        Grade grade = gradeService.findOne(gid);
        grade.setName(gname);
        gradeService.saveGrade(grade);
        Pageable pageable = new PageRequest(0,4);
        Page<Grade> page = gradeService.pageGrade(pageable);
        List<Grade> gradeList = page.getContent();
        modelAndView.addObject("page",page);
        modelAndView.addObject("allgrades",gradeList);
        modelAndView.setViewName("listgrade");
        return modelAndView;
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
    public ModelAndView getGradeById(@RequestParam Integer gradeId){
        ModelAndView modelAndView = new ModelAndView();
        Grade grade = gradeService.findOne(gradeId);
        modelAndView.addObject("grade",grade);
        modelAndView.setViewName("updategrade");
        return modelAndView;
    }

    @RequestMapping(value = /*"/search/{name}"*/"/getGradeByName.action")
    public Grade getGradeByName(@PathVariable String name){
        return gradeService.findByName(name);
    }
}
