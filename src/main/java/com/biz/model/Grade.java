
package com.biz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grade")
public class Grade implements Serializable{

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Id
    private long gid;
    @Column(name= "name")
    private String name;
    @Column(name= "maxsize")
    private Integer maxsize=0;
    @Column(name= "avgscore")
    private Double avgscore=0.0;

    /**
     * 班级拥有的学生
     */
    //拥有mappedBy注解的实体类为关系被维护端,mappedBy="grade" 中的grade是Student中的grade属性
    ///级联保存、更新、删除、刷新;延迟加载
    @OneToMany(mappedBy = "grade",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Student> students = new ArrayList<Student>();

    public Grade(){

    }

    public Grade(String gname) {
        this.name = gname;
    }

    public Grade(String gname,Integer maxsize,Double avgscore){

    }

    public long getGid() {
        return gid;
    }

    public void setGid(long gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(Integer maxsize) {
        this.maxsize = maxsize;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Double avgscore) {
        this.avgscore = avgscore;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

   /* public List<Student> getList() {
        return list;
    }  */

    public void setList(List<Student> list) {
        //this.list = list;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gname='" + name + '\'' +
                ", maxsize=" + maxsize +
                ", avgscore=" + avgscore +
                '}';
    }
}

