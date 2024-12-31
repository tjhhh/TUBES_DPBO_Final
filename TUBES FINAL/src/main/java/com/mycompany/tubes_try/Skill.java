/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Skill {
    private String skillName;
    private String tingkatanLevel;

    public Skill(String skillName, String tingkatanLevel) {
        this.skillName = skillName;
        this.tingkatanLevel = tingkatanLevel;
    }

    public String getSkillDetail() {
        return skillName + " (" + tingkatanLevel + ")";
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public void setTingkatanLevel(String tingkatanLevel) {
        this.tingkatanLevel = tingkatanLevel;
    }
}
