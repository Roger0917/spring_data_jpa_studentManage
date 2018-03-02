package com.biz.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "score")
public class Score implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue
    @Id
    private long id;
    @Column(name = "score")
    private Double score;

    /**
     * 一个分数对象为一个学生所选的一个科目的分数,故与学生是多对1的关系,与科目也是多对1的关系
     */

    /**
     * 所属学生
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;

    /**
     * 所属科目
     */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "subject_sid",referencedColumnName = "sid")
    private Subject subject;

    public Score(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
