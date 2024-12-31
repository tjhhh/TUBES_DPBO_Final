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
import java.util.HashMap;
import java.util.Scanner;
public class IMenu implements Menu{
    private HashMap<Integer, Pengguna> users = new HashMap<>();
    public ArrayList<Lowongan> semuaLowongan = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int idPengguna = 10001;
    
    public void tampilkanSemuaLowongan() {
        if (semuaLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan yang tersedia.");
        } else {
            System.out.println("\n=== Daftar Semua Lowongan ===");
            for (Lowongan lowongan : semuaLowongan) {
                lowongan.tampilkanLowongan();
                System.out.println("-------------------");
            }
        }
    }
    public void tambahLowongan(Lowongan lowongan) {
        semuaLowongan.add(lowongan);
    }
    
    public IMenu() {
        users.put(idPengguna, new AdminPerusahaan(idPengguna++, "admin", "admin123", "Admin", "admin1234@gmail.com"));
        users.put(idPengguna, new AdminPerusahaan(idPengguna++, "admin2", "admin123", "Admin", "admin2@gmail.com"));
        users.put(idPengguna, new Pelamar(idPengguna++, "pelamar", "pelamar123", "Pelamar", "pelamar@gmail.com"));
    }



    @Override
    public void menuUtama() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Login");
        System.out.println("2. Daftar");
        System.out.println("3. Lihat Akun Terdaftar");
        System.out.println("0. Keluar");
    }
    
     @Override
    public void menuPelamar(Pelamar pelamar) {
        
        while (true) {
            System.out.println("\n=== MENU PELAMAR ===");
            System.out.println("1. Lihat Lamaran");
            System.out.println("2. Lihat Lowongan");
            System.out.println("3. Resume");
            System.out.println("4. Lamar Pekerjaan");
            System.out.println("5. Notifikasi");
            System.out.println("6. Rekomendasi");
            System.out.println("7. Tampilkan Info Pengguna");
            System.out.println("9. Keluar");
            System.out.print(">>Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    pelamar.showAllApply(this);
                    break;
                case 2:
                    tampilkanSemuaLowongan();
                    break;
                case 3:
                    pelamar.runResume(pelamar);
                    break;
                case 4:
                    pelamar.applyJob(this);
                    break;
                case 5 :
                    pelamar.showNotification();
                    break;
                case 6:
                    pelamar.showRecommendation();
                case 7: 
                    pelamar.showInfoPengguna();
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void menuAdminPerusahaan(AdminPerusahaan admin) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Buat Lowongan");
            System.out.println("2. Lihat Lamaran");
            System.out.println("3. Lihat Lowongan");
            System.out.println("4. Buat Event");
            System.out.println("5. Notifikasi");
            System.out.println("6. Proses Lamaran");
            System.out.println("7. Tampilkan Info Pengguna");
            System.out.println("9. Keluar");
            System.out.print(">>Masukkan pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    admin.addLowongan(this);
                    break;
                case 2:
                    admin.showApply();
                    break;
                case 3:
                    admin.showLowonganSaya();
                case 4:
                    admin.addEvent();
                    break;
                case 5:
                    admin.showNotification();
                    break;
                case 6:
                    admin.processApply(this);
                    break;
                case 7:
                    admin.showInfoPengguna();
                case 9:
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
    
    public Lowongan getLowonganById(int idLowongan) {
        for (Lowongan lowongan : semuaLowongan) {
            if (lowongan.getIdLowongan() == idLowongan) {
                return lowongan; 
            }
        }
        return null; 
    }

    public Pengguna getPenggunaById(int idPengguna) {
        return users.get(idPengguna);
    }


    
    @Override
    public void menuResume(){
        System.out.println("\n===Menu Resume===");
        System.out.println("1. Tambahkan Resume");
        System.out.println("2. Hapus Resume");
        System.out.println("3. Edit Resume");
        System.out.println("4. Lihat Semua Resume");
        System.out.println("9. Keluar");
       
        
        
    }
    
    //==========================================================================
    @Override
    public boolean Login() {
        System.out.println("\n=== LOGIN ===");
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        for (Pengguna user : users.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login Berhasil sebagai " + user.getRole());
                if (user instanceof Pelamar) {
                    menuPelamar((Pelamar) user);
                } else if (user instanceof AdminPerusahaan) {
                    menuAdminPerusahaan((AdminPerusahaan) user);
                }
                return true;
            }
        }

        System.out.println("Login Gagal. Username atau Password salah.");
        return false;
    }


   @Override
    public void Daftar() {
        System.out.println("\n=== DAFTAR AKUN ===");
        System.out.print("Masukkan Username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();
        System.out.print("Pilih Role (Pelamar/Admin): ");
        String role = scanner.nextLine();
        System.out.print("Masukkan Email: ");
        String email = scanner.nextLine();

        if (role.equalsIgnoreCase("Pelamar")) {
            Pelamar pelamar = new Pelamar(idPengguna, username, password, role, email);
            users.put(idPengguna++, pelamar);
            System.out.println("Akun Pelamar berhasil didaftarkan!");
        } else if (role.equalsIgnoreCase("Admin")) {
            AdminPerusahaan admin = new AdminPerusahaan(idPengguna, username, password, role, email);
            users.put(idPengguna++, admin);
            System.out.println("Akun Admin berhasil didaftarkan!");
        } else {
            System.out.println("Role tidak valid!");
        }
    }

   
    
    @Override
    public void ShowAllAccount() {
        System.out.println("\n=== Akun yang Terdaftar ===");
        for (HashMap.Entry<Integer, Pengguna> entry : users.entrySet()) {
            Pengguna user = entry.getValue();
            System.out.println("ID: " + entry.getKey() + ", Username: " + user.getUsername() + ", Role: " + user.getRole());
        }
    }

   
}