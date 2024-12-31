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
import java.util.Scanner;
public class AdminPerusahaan extends Pengguna {
    private ArrayList<Notifikasi> daftarNotifikasi = new ArrayList<>();
    private ArrayList<Lowongan> daftarLowongan = new ArrayList<>();
    
    private int idLowonganCounter = 1; 
    private Pelamar pelamar;
    
    Scanner scanner = new Scanner(System.in);
    public AdminPerusahaan(int idPengguna,String username,String password, String role, String email){
        super(idPengguna,username,password,"Admin", email);
    }
    
    public Lowongan addLowongan(IMenu menu) {
        System.out.println("\n=== Tambahkan Lowongan Baru ===");
        System.out.print("Nama Perusahaan: ");
        String namaPerusahaan = scanner.nextLine();
        System.out.print("Posisi: ");
        String posisi = scanner.nextLine();
        System.out.print("Deskripsi Pekerjaan: ");
        String deskripsi = scanner.nextLine();
        System.out.print("Kualifikasi: ");
        String kualifikasi = scanner.nextLine();
        String status = "Dibuka"; 

        Lowongan lowonganBaru = new Lowongan(idLowonganCounter++, namaPerusahaan, posisi, deskripsi, kualifikasi, status,this,pelamar);
        daftarLowongan.add(lowonganBaru);
        menu.tambahLowongan(lowonganBaru); 

        System.out.println("Lowongan berhasil ditambahkan!");
        return lowonganBaru;
    }
    
    public void showAllLowongan() {
        if (daftarLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan yang tersedia.");
        } else {
            for (Lowongan lowongan : daftarLowongan) {
                lowongan.tampilkanLowongan();
                System.out.println("-------------------");
            }
        }
    }
    public void updateStatusLowongan(int idLowongan, String statusBaru) {
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getIdLowongan() == idLowongan) {
                lowongan.setStatus(statusBaru);
                System.out.println("Status lowongan ID " + idLowongan + " berhasil diupdate menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Lowongan dengan ID " + idLowongan + " tidak ditemukan.");
    }
    public void addEvent(){
        System.out.println("Coming Soon....");
    }

    

    public void showApply(){
        if (daftarLowongan.isEmpty()) {
            System.out.println("Anda belum memiliki lowongan yang aktif.");
            return;
        }

        for (Lowongan lowongan : daftarLowongan) {
            System.out.println("\n=== Lamaran untuk Lowongan: " + lowongan.getPosisi() + " ===");
            lowongan.tampilkanLamaran();
        }
    }
    
    public void showLowonganSaya() {
    if (daftarLowongan.isEmpty()) {
        System.out.println("Anda belum membuat lowongan pekerjaan.");
        return;
    }

    System.out.println("\n=== Lowongan yang Anda Buat ===");
    for (Lowongan lowongan : daftarLowongan) {
        System.out.println("ID Lowongan: " + lowongan.getIdLowongan());
        System.out.println("Nama Perusahaan: " + lowongan.getNamaPerusahaan());
        System.out.println("Posisi: " + lowongan.getPosisi());
        System.out.println("Status: " + lowongan.getStatus());
        System.out.println("-------------------");
    }
}

    public void processApply(IMenu menu) {
        if (daftarLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan yang tersedia.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        
        System.out.println("\n=== Daftar Lowongan ===");
        for (Lowongan lowongan : daftarLowongan) {
            System.out.println("ID Lowongan: " + lowongan.getIdLowongan() + " | Posisi: " + lowongan.getPosisi());
        }

        
        System.out.print("Masukkan ID Lowongan yang ingin diproses: ");
        int idLowongan = scanner.nextInt();
        scanner.nextLine(); 

        
        Lowongan targetLowongan = null;
        for (Lowongan lowongan : daftarLowongan) {
            if (lowongan.getIdLowongan() == idLowongan) {
                targetLowongan = lowongan;
                break;
            }
        }

        if (targetLowongan == null) {
            System.out.println("Lowongan dengan ID tersebut tidak ditemukan.");
            return;
        }

        
        if (targetLowongan.getDaftarLamaran().isEmpty()) {
            System.out.println("Tidak ada lamaran untuk lowongan ini.");
            return;
        }

        
        if (targetLowongan.getDaftarLamaran().isEmpty()) {
            System.out.println("Tidak ada lamaran untuk lowongan ini.");
            return;
        }

        System.out.println("\n=== Daftar Pelamar untuk Lowongan: " + targetLowongan.getPosisi() + " ===");
        for (Lamaran lamaran : targetLowongan.getDaftarLamaran()) {
            Pelamar pelamar = (Pelamar) menu.getPenggunaById(lamaran.getIdPelamar());
            if (pelamar != null) {
                String status = lamaran.isProcessed() ? "(sudah)" : ""; // Cek apakah lamaran sudah diproses
                System.out.println("ID Pelamar: " + pelamar.getIdPengguna() + " " + status);
                System.out.println("Nama: " + pelamar.getUsername());
                System.out.println("Email: " + pelamar.getEmail());
            }
        }

        
        System.out.print("Masukkan ID Pelamar yang ingin dilihat: ");
        int idPelamar = scanner.nextInt();
        scanner.nextLine(); 

        
        Pelamar pelamar = (Pelamar) menu.getPenggunaById(idPelamar);
        if (pelamar == null) {
            System.out.println("Pelamar dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.println("\n=== Detail Pelamar ===");
        System.out.println("Email: " + pelamar.getEmail());
        
        pelamar.showAllResume();

        
        ArrayList<Lamaran> lamaranPelamar = new ArrayList<>();
        for (Lamaran lamaran : targetLowongan.getDaftarLamaran()) {
            if (lamaran.getIdPelamar() == idPelamar && !lamaran.isProcessed()) {
                lamaranPelamar.add(lamaran);
            }
        }

        if (lamaranPelamar.isEmpty()) {
            System.out.println("Tidak ada lamaran yang dapat diproses untuk pelamar ini.");
            return;
        }

        System.out.println("\n=== Lamaran dari Pelamar ID " + idPelamar + " ===");
        for (Lamaran lamaran : lamaranPelamar) {
            System.out.println("ID Lamaran: " + lamaran.getIdLamaran() + " | Status: " + lamaran.getStatusLamaran());
        }

        
        System.out.print("Masukkan ID Lamaran yang ingin diproses: ");
        int idLamaran = scanner.nextInt();
        scanner.nextLine(); 

        
        Lamaran targetLamaran = null;
        for (Lamaran lamaran : lamaranPelamar) {
            if (lamaran.getIdLamaran() == idLamaran) {
                targetLamaran = lamaran;
                break;
            }
        }

        if (targetLamaran == null) {
            System.out.println("ID Lamaran tidak ditemukan atau sudah diperiksa.");
            return;
        }

        
        System.out.println("1. Terima Lamaran");
        System.out.println("2. Tolak Lamaran");
        System.out.print("Pilih aksi: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Konsumsi newline

        String statusBaru;
        if (pilihan == 1) {
            statusBaru = "Diterima";
        } else if (pilihan == 2) {
            statusBaru = "Ditolak";
        } else {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        
        targetLamaran.setStatusLamaran(statusBaru);
        targetLamaran.setProcessed(true); 

        
        String waktuPengiriman = scanner.nextLine();
        
        String pesanNotifikasi = "Admin telah memproses lamaran Anda untuk posisi " 
                                 + targetLowongan.getPosisi() + ". Status: " + statusBaru;
        Notifikasi notifikasi = new Notifikasi(pelamar.getIdPengguna(), pesanNotifikasi, waktuPengiriman);
        pelamar.tambahNotifikasi(notifikasi);

        System.out.println("Lamaran dengan ID " + idLamaran + " telah " + statusBaru.toLowerCase() + ".");
    }



    @Override
    public void showNotification(){
        if (daftarNotifikasi.isEmpty()) {
            System.out.println("Tidak ada notifikasi untuk Anda.");
        } else {
            System.out.println("\n=== Notifikasi Anda ===");
            for (Notifikasi notifikasi : daftarNotifikasi) {
                System.out.println("ID Notifikasi: " + notifikasi.getIdNotifikasi());
                System.out.println("Pesan: " + notifikasi.getPesan());
                System.out.println("Waktu Pengiriman: " + notifikasi.getWaktuPengiriman());
                System.out.println("-------------------");
            }
        }
    }

    public void tambahNotifikasi(Notifikasi notifikasi) {
        daftarNotifikasi.add(notifikasi);
    }

    public void showInfoPengguna(){
        System.out.println("======Informasi Admin Perusahaan======");
        System.out.println("ID Admin\t:" + getIdPengguna());
        System.out.println("Username\t:" + getUsername());
        System.out.println("Role\t\t:" + getRole());
        System.out.println("Email\t\t:" +getEmail());
    }
}