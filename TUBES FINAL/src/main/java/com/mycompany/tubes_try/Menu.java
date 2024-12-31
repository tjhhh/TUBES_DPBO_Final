/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public interface Menu {
    public void menuUtama();
    public void menuPelamar(Pelamar pelamar);
    public void menuAdminPerusahaan(AdminPerusahaan admin);
    
    public void menuResume();
    public boolean Login();
    public void Daftar();
    public void ShowAllAccount();
}
