package com.cubemora.ax_courses.services;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.cubemora.ax_courses.models.students;



@XmlRootElement
public class studentsList {
    private List<students> studentList;

    @XmlElement(name = "student")
    public List<students> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<students> studentList) {
        this.studentList = studentList;
    }
}