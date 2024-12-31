/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;



/**
 *
 * @author nhqkb
 */
import java.util.ArrayList;
public class Lowongan {
    private int idLowongan; // ID unik untuk lowongan
    private String namaPerusahaan; // Nama perusahaan
    private String posisi; // Posisi pekerjaan yang ditawarkan
    private String deskripsiPekerjaan; // Deskripsi pekerjaan
    private String kualifikasi; // Kualifikasi pelamar yang dibutuhkan
    private String status; // Status lowongan (contoh: "Dibuka", "Ditutup")
    private ArrayList<Lamaran> daftarLamaran = new ArrayList<>();
    private AdminPerusahaan adminPerusahaan;
    private Pelamar pelamar;

    

    // Konstruktor
    public Lowongan(int idLowongan, String namaPerusahaan, String posisi, String deskripsiPekerjaan, String kualifikasi, String status, AdminPerusahaan adminPerusahaan,Pelamar pelamar) {
        this.idLowongan = idLowongan;
        this.namaPerusahaan = namaPerusahaan;
        this.posisi = posisi;
        this.deskripsiPekerjaan = deskripsiPekerjaan;
        this.kualifikasi = kualifikasi;
        this.status = status;
        this.adminPerusahaan = adminPerusahaan; // Simpan referensi admin
        this.pelamar = pelamar;
    }
    

    // Getter dan Setter
    public int getIdLowongan() {
        return idLowongan;
    }

    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getDeskripsiPekerjaan() {
        return deskripsiPekerjaan;
    }

    public void setDeskripsiPekerjaan(String deskripsiPekerjaan) {
        this.deskripsiPekerjaan = deskripsiPekerjaan;
    }

    public String getKualifikasi() {
        return kualifikasi;
    }

    public void setKualifikasi(String kualifikasi) {
        this.kualifikasi = kualifikasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // Getter untuk daftar lamaran
    public ArrayList<Lamaran> getDaftarLamaran() {
        return daftarLamaran;
    }

    // Tambahkan lamaran ke daftar lamaran
    public void addLamaran(Lamaran lamaran) {
        daftarLamaran.add(lamaran);
    }
    public AdminPerusahaan getAdminPerusahaan() {
        return adminPerusahaan;
    }
    

    // Method untuk menampilkan semua lamaran
    public void tampilkanLamaran() {
        if (daftarLamaran.isEmpty()) {
            System.out.println("Belum ada lamaran yang masuk.");
        } else {
            for (Lamaran lamaran : daftarLamaran) {
                System.out.println("ID Lamaran: " + lamaran.getIdLamaran() +
                                   ", ID Pelamar: " + lamaran.getIdPelamar() +
                                   ", Status: " + lamaran.getStatusLamaran());
            }
        }
    }

    // Method untuk menampilkan detail lowongan
    public void tampilkanLowongan() {
        System.out.println("ID Lowongan: " + idLowongan);
        System.out.println("Nama Perusahaan: " + namaPerusahaan);
        System.out.println("Posisi: " + posisi);
        System.out.println("Deskripsi Pekerjaan: " + deskripsiPekerjaan);
        System.out.println("Kualifikasi: " + kualifikasi);
        System.out.println("Status: " + status);
    }
}