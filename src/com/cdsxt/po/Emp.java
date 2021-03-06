package com.cdsxt.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Past;
import java.util.Date;

@Entity
@Table(name = "emp")
public class Emp {

    @Id
    @SequenceGenerator(name = "empGen", sequenceName = "seq_emp")
    @GeneratedValue(generator = "empGen")
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;

    @JsonFormat(pattern = "yyyy年MM月dd日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @NotEmpty(message = "时间不能为空")
    // @Past // (message = "时间必须是过去的时间")
    private Date hiredate;
    private Double sal;
    private Double comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    @JsonIgnore
    private Dept dept;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public Double getComm() {
        return comm;
    }

    public void setComm(Double comm) {
        this.comm = comm;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hiredate=" + hiredate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", dept=" + dept +
                '}';
    }
}
