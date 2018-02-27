package com.biz.controller;

import java.util.Date;
import java.util.List;

import com.biz.model.Grade;
import com.biz.model.Student;
import com.biz.model.Subject;
import com.biz.service.IGradeService;
import com.biz.service.IStudentService;
import com.biz.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private IGradeService gradeService;
    @Autowired
    private ISubjectService subjectService;

    @RequestMapping(value = "/pageGrade.action")
    public ModelAndView grade(){
        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = new PageRequest(0,4);
        Page<Grade> page= gradeService.pageGrade(pageable);
        List<Grade> gradeList= page.getContent();
        for (int i = 0; i <gradeList.size() ; i++) {
            System.out.println(gradeList.get(i).getGid()+gradeList.get(i).getName()+gradeList.get(i).getMaxsize()+gradeList.get(i).getAvgscore());

        }
        modelAndView.addObject("allgrades",gradeList);
        modelAndView.setViewName("listgrade");
        return modelAndView;
    }

    @RequestMapping(value = "/pageStudent.action")
    public ModelAndView student(){
        ModelAndView modelAndView = new ModelAndView();
        /*List<Student> studentList = studentService.findAll();
        for (Student student:
             studentList) {
            System.out.println(student.getId()+student.getSid()+student.getName()+student.getSex()+student.getBirthday());
        }*/
        Pageable pageable = new PageRequest(0,4);
        Page<Student> page= studentService.pageStudent(pageable);
        System.out.println("totalPages"+page.getTotalPages()+"totalElements"+page.getTotalElements()+"currentPageSize"+page.getNumberOfElements()+
                +page.getNumber());
       // System.out.println(page.getContent());
        List<Student> list= page.getContent();
        modelAndView.addObject("allstudents",list);
        modelAndView.setViewName("liststudent");
        return modelAndView;
    }

    @RequestMapping(value = "/pageSubject.action")
    public ModelAndView subject(){
        ModelAndView modelAndView = new ModelAndView();
        Pageable pageable = new PageRequest(0,4);
        Page<Subject> page= subjectService.pageSubject(pageable);
        List<Subject> subjectList =  page.getContent();
        modelAndView.addObject("allsubjects",subjectList);
        modelAndView.setViewName("listsubject");
        return modelAndView;
    }

    @RequestMapping(value = "/add/{sid}/{name}/{sex}")
    public Student addStudent1(@PathVariable String sid,@PathVariable String name
    ,@PathVariable Integer sex){

        Student student = new Student(sid,name,sex);
        studentService.saveStudent(student);
        return student;
    }

    @RequestMapping(value = "/add/{sid}/{name}/{sex}/{photo}/{birthday}")
    public Student addStudent2(@PathVariable String sid,@PathVariable String name,
                              @PathVariable Integer sex,@PathVariable String photo,@PathVariable
                                      Date birthday){
        Student student = new Student(sid,name,photo,sex,birthday);
        studentService.saveStudent(student);
        return student;
    }

    @RequestMapping(value = "/update/{id}/{sid}/{name}/{sex}")
    public Student updateStudent1(@PathVariable Integer id,@PathVariable String sid,@PathVariable String name
            ,@PathVariable Integer sex){
        Student student = studentService.findOne(id);
        student.setSid(sid);
        student.setName(name);
        student.setSex(sex);
        studentService.saveStudent(student);
        return student;
    }
    @RequestMapping(value = "/update/{id}/{snewid}{name}/{sex}/{photo}/{birthday}")
    public Student updateStudent2(@PathVariable Integer id,@PathVariable String snewid,@PathVariable String name,
                              @PathVariable Integer sex,@PathVariable String photo,@PathVariable
                                      Date birthday){
        Student student = studentService.findOne(id);
        student.setSid(snewid);
        student.setName(name);
        student.setSex(sex);
        student.setPhoto(photo);
        student.setBirthday(birthday);
        studentService.saveStudent(student);
        return student;
    }



    @RequestMapping(value = "/deleteStudent.action")
    public void deleteStudent(@PathVariable int id){
        studentService.delete(id);
    }

    @RequestMapping(value = "/getAllStudentsById.action")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @RequestMapping(value = /*"/{id}"*/"/getStudentById.action")
    public Student getStudentById(@PathVariable int id){
        Student student = studentService.findOne(id);
        return student;
    }

    @RequestMapping(value = /*"/search/name/{name}"*/"/getStudentsByName.action")
    public List<Student> getStudentsByName(@PathVariable String name){
        List<Student> list = studentService.findByName(name);
        return list;
    }
}
