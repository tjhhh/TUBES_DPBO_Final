/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public abstract class Pengguna {
    private String username;
    private String password;
    private String role;
    private String email;
    private int idPengguna;
    
    public Pengguna(int idPengguna,String username,String password,String role, String email){
        this.idPengguna = idPengguna;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdPengguna() {
        return idPengguna;
    }

    public void setIdPengguna(int idPengguna) {
        this.idPengguna = idPengguna;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    
    public abstract void showInfoPengguna();
    public abstract void showNotification();
    
    
}
