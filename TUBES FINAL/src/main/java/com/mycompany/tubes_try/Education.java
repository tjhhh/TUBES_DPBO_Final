/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Education {
    private String school;
    private String degree;
    private String fieldOfStudy;
    private String startDate;
    private String endDate;

    public Education(String school, String degree, String fieldOfStudy, String startDate, String endDate) {
        this.school = school;
        this.degree = degree;
        this.fieldOfStudy = fieldOfStudy;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    

    public String getEducation() {
        return school + ", " + degree + " " + fieldOfStudy;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}