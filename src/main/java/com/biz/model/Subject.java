
package com.biz.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Id
    private long sid;
    @Column(name = "name")
    private String name;
    @Column(name= "maxsize")
    private Integer maxsize=0;
    @Column(name= "avgscore")
    private Double avgscore=0.0;

    /**
     * 学科拥有的学生
     */
    @ManyToMany(mappedBy = "subjects")
    //只需要设置mappedBy="subjects"表明Subject实体是关系被维护端就可以了
    //级联保存、级联删除等之类的属性在多对多关系中是不需要设置
    //不能说删了学科,把学生也删掉,学生还可以玩其他的科目
    private Set<Student> students = new HashSet<Student>();

    public Subject(){

    }

    public Subject(String sname) {
        this.name = sname;
        //this.maxsize = maxsize;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "sid=" + sid +
                ", sname='" + name + '\'' +
                ", maxsize=" + maxsize +
                ", avgscore=" + avgscore +
                '}';
    }
}
