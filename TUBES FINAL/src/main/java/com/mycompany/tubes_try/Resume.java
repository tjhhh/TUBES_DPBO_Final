/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Resume {
    private int idDokumen;
    private Skill skill;
    private Education pendidikan;
    private Experienced pengalaman;
    private String name;
    private int age;

    public Resume(String name,int age,int idDokumen, Skill skill, Education pendidikan, Experienced pengalaman) {
        this.name = name;
        this.age = age;
        this.idDokumen = idDokumen;
        this.skill = skill;
        this.pendidikan = pendidikan;
        this.pengalaman = pengalaman;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
  
    public int getIdDokumen() {
        return idDokumen;
    }
    
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void setEducation(Education pendidikan) {
        this.pendidikan = pendidikan;
    }

    public void setExperienced(Experienced pengalaman) {
        this.pengalaman = pengalaman;
    }

    public void membuatResume() {
        System.out.println("\n=== Resume ===");
        System.out.println("ID Dokumen: " + idDokumen);
        System.out.println("Nama: " + name);
        System.out.println("Umur: "+age+" tahun");
        System.out.println("Pendidikan: " + pendidikan.getEducation());
        System.out.println("Skill     : " + skill.getSkillDetail());
        System.out.println("Pengalaman: " + pengalaman.getPengalamanLengkap());

    }
}
