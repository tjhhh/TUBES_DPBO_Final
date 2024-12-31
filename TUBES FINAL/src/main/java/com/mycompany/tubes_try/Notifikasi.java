/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
public class Notifikasi {
    private int idNotifikasi; // ID unik untuk setiap notifikasi
    private int idPelamar; // ID pelamar yang menerima notifikasi
    private String pesan; // Pesan notifikasi
    private String waktuPengiriman; // Waktu pengiriman notifikasi dalam format string
    private boolean sudahDibaca; // Status apakah notifikasi sudah dibaca

    // Constructor
    public Notifikasi(int idPelamar, String pesan, String waktuPengiriman) {
        this.idNotifikasi = generateIdNotifikasi();
        this.idPelamar = idPelamar;
        this.pesan = pesan;
        this.waktuPengiriman = waktuPengiriman; // Waktu sebagai string
        this.sudahDibaca = false; // Default belum dibaca
    }

    // Getter dan Setter
    public int getIdNotifikasi() {
        return idNotifikasi;
    }

    public int getIdPelamar() {
        return idPelamar;
    }

    public String getPesan() {
        return pesan;
    }

    public String getWaktuPengiriman() {
        return waktuPengiriman;
    }


    // Method untuk menampilkan detail notifikasi
    public void tampilkanNotifikasi() {
        System.out.println("Notifikasi untuk Pelamar ID " + idPelamar + ": " + pesan + " pada " + waktuPengiriman);
    }

    // Generate ID unik untuk notifikasi
    private static int idCounter = 1;
    private static int generateIdNotifikasi() {
        return idCounter++;
    }
}

