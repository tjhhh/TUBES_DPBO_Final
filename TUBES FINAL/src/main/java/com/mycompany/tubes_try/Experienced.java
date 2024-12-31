/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Experienced {
    private String position;
    private String company;
    private String startDate;
    private String endDate;
    private String description;

    public Experienced(String position, String company, String startDate, String endDate, String description) {
        this.position = position;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getPengalamanLengkap() {
        return position + " di " + company + " (" + startDate + " - " + endDate + ")" + "\n" + "Deskripsi : " +description;
    }        

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}