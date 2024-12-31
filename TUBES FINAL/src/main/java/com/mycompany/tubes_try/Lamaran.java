/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Lamaran {
    private int idLamaran; // ID unik untuk lamaran
    private int idLowongan; // ID lowongan terkait
    private int idPelamar; // ID pelamar yang mengajukan lamaran
    private int idDokumen;
    private String tanggalLamaran; // Tanggal lamaran diajukan
    private String statusLamaran; // Status lamaran (contoh: "Diterima", "Ditolak", "Dalam Proses")
    private Pelamar pelamar;
    private boolean isProcessed;

    // Konstruktor
    public Lamaran(int idLamaran, int idLowongan, int idPelamar,int idDokumen, String tanggalLamaran, String statusLamaran) {
        this.idLamaran = idLamaran;
        this.idLowongan = idLowongan;
        this.idPelamar = idPelamar;
        this.idDokumen = idDokumen;
        this.tanggalLamaran = tanggalLamaran;
        this.statusLamaran = statusLamaran;
    }

    public int getIdDokumen() {
        return idDokumen;
    }

    public void setIdResume(int idDokumen) {
        this.idDokumen = idDokumen;
    }
    // Getter dan Setter
    public int getIdLamaran() {
        return idLamaran;
    }

    public void setIdLamaran(int idLamaran) {
        this.idLamaran = idLamaran;
    }

    public int getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public void setIdPelamar(int idPelamar) {
        this.idPelamar = idPelamar;
    }

    public String getTanggalLamaran() {
        return tanggalLamaran;
    }

    public void setTanggalLamaran(String tanggalLamaran) {
        this.tanggalLamaran = tanggalLamaran;
    }

    public String getStatusLamaran() {
        return statusLamaran;
    }

    public void setStatusLamaran(String statusLamaran) {
        this.statusLamaran = statusLamaran;
    }
    public Pelamar getPelamar(){
        return pelamar;
    }
    
    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    // Method untuk menampilkan detail lamaran
    public void tampilkanLamaran() {
        System.out.println("ID Lamaran: " + idLamaran);
        System.out.println("ID Lowongan: " + idLowongan);
        System.out.println("ID Pelamar: " + idPelamar);
        System.out.println("Tanggal Lamaran: " + tanggalLamaran);
        System.out.println("Status Lamaran: " + statusLamaran);
    }
}