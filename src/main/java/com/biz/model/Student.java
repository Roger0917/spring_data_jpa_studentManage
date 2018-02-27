package com.biz.model;

import com.biz.SpringDataJpaDemoApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.context.SpringBootTest;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "student")
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringDataJpaDemoApplication.class)*/
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Id
    private long id;
    @Column(name = "sid")
    private String sid;
    @Column(name = "name")
    private String name;
    @Column(name = "photo")
    private String photo;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "birthday")
    private Date birthday;

    /**
     * 所属班级
     */
    //可选属性optional=false 表示Grade不能为空
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "grade_gid", referencedColumnName = "gid") //设置在学生表中的外键
    private Grade grade;

    /**
     * 学生选的课
     */
    @ManyToMany
    /**
     * 关系维护端,负责多对多关系的绑定和解除
     * @JoinTable 注解的name属性指定关联表的名字,joinColumns指定外键的名字,关联到关系维护端(student)
     * inverseJoinColumns 指定外键的名字,关联到关系被维护端(subject)
     * 其实可以不使用@JoinTable 默认的生成的关联表名称为主表表名_从表表名 即student_subject
     * 关联到主表的外键名 主表名_主表主键列名 即student_id
     * 关联到从表的外键名 从表名_从表主键列名 即subject_id
     * 主表就是关系维护端对应的表,从表就是关系被维护端对应的表
     */
    @JoinTable(name="student_subject",joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private Set<Subject> subjects = new HashSet<Subject>();

    public Student(){

    }
    public Student(String sid, String name, String photo, Integer sex, Date birthday) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
    }

    public Student(String sid, String name, Integer sex) {
        this.sid = sid;
        this.name = name;
        this.photo = photo;
        this.sex = sex;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                '}';
    }

/*    @Before
    public void before(){
        System.out.println("before");
    }
    @After
    public void after(){
        System.out.println("after");
    }
    @Test
    public void testmanytomany(){
        Student student1 = new Student();
        student1.setName("777");
    }*/
}
