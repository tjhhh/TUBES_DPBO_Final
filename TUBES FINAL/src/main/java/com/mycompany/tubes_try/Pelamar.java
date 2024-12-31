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
public class Pelamar extends Pengguna {
    private ArrayList<Resume> resumes;
    
    Scanner scanner=new Scanner(System.in);
    private ArrayList<Notifikasi> daftarNotifikasi = new ArrayList<>();
    private ArrayList<Lamaran> daftarLamaran = new ArrayList<>();
    private int idLamaranCounter = 1;
    
    
    public Pelamar(int idPengguna,String username,String password, String role, String email){
        super(idPengguna,username,password,"Pelamar", email);
        this.resumes = new ArrayList<>();
        
    }
    
    public ArrayList<Resume> getResumes() {
        return resumes; 
    }
    
    public void runResume(Pelamar pelamar){
        while(true){
            Menu menu = new IMenu();
            menu.menuResume();
            System.out.println(">>Masukkan pilihan: ");
            int pilihanResume = scanner.nextInt();
            scanner.nextLine(); 
                switch (pilihanResume) {
                        case 1:
                            pelamar.resumeManagement(scanner, pelamar);
                            break;
                        case 2:
                            System.out.print("Masukkan ID Dokumen yang ingin dihapus: ");
                            int idHapus = scanner.nextInt();
                            if (pelamar.removeResume(idHapus)) {
                                System.out.println("Resume berhasil dihapus!");
                            } else {
                                System.out.println("Resume dengan ID tersebut tidak ditemukan.");
                            }
                            break;
                        case 3:
                            System.out.print("Masukkan ID Dokumen yang ingin diubah: ");
                            int idUbah = scanner.nextInt();
                            scanner.nextLine(); 

                            if (pelamar.isIdDokumenExist(idUbah)) {
                                System.out.println("Pilih bagian yang ingin diedit:");
                                System.out.println("1. Skill");
                                System.out.println("2. Pendidikan");
                                System.out.println("3. Pengalaman");
                                System.out.print(">>Pilih opsi: ");
                                int opsiEdit = scanner.nextInt();
                                scanner.nextLine(); 

                                for (Resume r : pelamar.getResumes()) {
                                    if (r.getIdDokumen() == idUbah) {
                                        switch (opsiEdit) {
                                            case 1:
                                                    

                                                System.out.print("Masukkan Nama Skill Baru: ");
                                                String newSkillName = scanner.nextLine();
                                                System.out.print("Masukkan Tingkatan Skill Baru: ");
                                                String newSkillLevel = scanner.nextLine();
                                                r.setSkill(new Skill(newSkillName, newSkillLevel));
                                                System.out.println("Skill berhasil diubah!");
                                                break;

                                            case 2:
                                                   
                                                System.out.print("Masukkan Nama Universitas Baru: ");
                                                String newSchool = scanner.nextLine();
                                                System.out.print("Masukkan Gelar Baru: ");
                                                String newDegree = scanner.nextLine();
                                                System.out.print("Masukkan Jurusan Baru: ");
                                                String newField = scanner.nextLine();
                                                System.out.print("Masukkan Tanggal Mulai Baru: ");
                                                String newStart = scanner.nextLine();
                                                System.out.print("Masukkan Tanggal Selesai Baru: ");
                                                String newEnd = scanner.nextLine();
                                                r.setEducation(new Education(newSchool, newDegree, newField, newStart, newEnd));
                                                System.out.println("Pendidikan berhasil diubah!");
                                                 break;

                                            case 3:
                                                    // Edit Pengalaman
                                                System.out.print("Masukkan Posisi Baru: ");
                                                String newPosition = scanner.nextLine();
                                                System.out.print("Masukkan Nama Perusahaan Baru: ");
                                                String newCompany = scanner.nextLine();
                                                System.out.print("Masukkan Tanggal Mulai Baru: ");
                                                String newStartExp = scanner.nextLine();
                                                System.out.print("Masukkan Tanggal Selesai Baru: ");
                                                String newEndExp = scanner.nextLine();
                                                System.out.print("Masukkan Deskripsi Baru: ");
                                                String newDesc = scanner.nextLine();
                                                r.setExperienced(new Experienced(newPosition, newCompany, newStartExp, newEndExp, newDesc));
                                                System.out.println("Pengalaman berhasil diubah!");
                                                break;
                                            default:
                                                System.out.println("Pilihan tidak valid.");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("ID Dokumen tidak ditemukan.");
                            }
                            break;
                        case 4:
                            pelamar.showAllResume();
                            break;
                        case 9:
                            System.out.println("Keluar program.");
                            return;
                        default:
                            System.out.println("Pilihan tidak valid.");
                            
                }
        }
    }
    
    public void resumeManagement(Scanner scanner,Pelamar pelamar){
        int idDokumen = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Masukkan ID Dokumen: ");
                idDokumen = Integer.parseInt(scanner.nextLine());
                validInput = true; // Berhenti jika input valid
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang valid.\n");
            }
        }

        while (isIdDokumenExist(idDokumen)) {
            try {
                System.out.println("\nID sudah ada, Masukkan ID baru");
                System.out.print("Masukkan ID Dokumen: ");
                idDokumen = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang valid.\n");
            }
        }
        System.out.println("Masukkan Nama anda ");
        String name = scanner.nextLine();
        
        int age = 0;
        validInput = false;
        while (!validInput) {
            try {
                System.out.print("Masukkan umur: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age > 0) {
                    validInput = true;
                } else {
                    System.out.println("Umur tidak valid. Harap masukkan angka positif.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka yang benar.\n");
            }
        }
        scanner.nextLine();
        System.out.println("\n===== Skill =====");
        System.out.print("Masukkan Nama Skill: ");
        String skillName = scanner.nextLine();
        System.out.print("Masukkan Tingkatan Skill: (Low-Intermediate-High)");
        String tingkatanLevel = scanner.nextLine();
        Skill skill = new Skill(skillName, tingkatanLevel);

        System.out.println("\n===== Pendidikan =====");
        System.out.print("Masukkan Nama Universitas: ");
        String school = scanner.nextLine();
        System.out.print("Masukkan Gelar: ");
        String degree = scanner.nextLine();
        System.out.print("Masukkan Jurusan: ");
        String fieldOfStudy = scanner.nextLine();
        System.out.print("Masukkan Tanggal Mulai: ");
        String startDate = scanner.nextLine();
        System.out.print("Masukkan Tanggal Selesai: ");
        String endDate = scanner.nextLine();
        Education pendidikan = new Education(school, degree, fieldOfStudy, startDate, endDate);

        System.out.println("\n===== Pengalaman =====");
        System.out.print("Masukkan Posisi Jabatan: ");
        String position = scanner.nextLine();
        System.out.print("Masukkan Nama Perusahaan: ");
        String company = scanner.nextLine();
        System.out.print("Masukkan Tanggal Mulai: ");
        String pengalamanStartDate = scanner.nextLine();
        System.out.print("Masukkan Tanggal Selesai: ");
        String pengalamanEndDate = scanner.nextLine();
        System.out.print("Masukkan Deskripsi Pekerjaan: ");
        String description = scanner.nextLine();
        Experienced pengalaman = new Experienced(position, company, pengalamanStartDate, pengalamanEndDate, description);

        Resume resume = new Resume(name,age,idDokumen, skill, pendidikan, pengalaman);
        pelamar.addResume(resume);
        System.out.println("Resume berhasil ditambahkan!");
    }
    
    public void addResume(Resume resume){
        resumes.add(resume);
    }
    public boolean removeResume(int idDokumen){
        return resumes.removeIf(resume -> resume.getIdDokumen() == idDokumen);
    }
    public void editResume(int idDokumen,Resume updateResume){
        for (int i = 0; i < resumes.size(); i++) {
            if (resumes.get(i).getIdDokumen() == idDokumen) {
                resumes.set(i, updateResume);
                return;
            }
        }
    }
    public void showAllResume(){
      if (resumes.isEmpty()) {
            System.out.println("Tidak ada resume yang tersedia.");
        } else {
            for (Resume resume : resumes) {
                resume.membuatResume();
            }
        }  
    }
    public boolean isIdDokumenExist(int idDokumen) {
        for (Resume resume : resumes) {
            if (resume.getIdDokumen() == idDokumen) {
                return true;
            }
        }
        return false;
    }
    
    public void showAllApply(IMenu menu) {
        if (daftarLamaran.isEmpty()) {
            System.out.println("Tidak ada lamaran yang diajukan.");
            return;
        }

        for (Lamaran lamaran : daftarLamaran) {
            System.out.println("\n=== Lamaran ===");
            System.out.println("ID Lamaran: " + lamaran.getIdLamaran());
            System.out.println("Status: " + lamaran.getStatusLamaran());
            System.out.println("Tanggal Lamaran: " + lamaran.getTanggalLamaran());

            
            Lowongan lowongan = menu.getLowonganById(lamaran.getIdLowongan());
            if (lowongan != null) {
                System.out.println("\n=== Detail Lowongan ===");
                System.out.println("ID Lowongan: " + lowongan.getIdLowongan());
                System.out.println("Posisi: " + lowongan.getPosisi());
                System.out.println("Perusahaan: " + lowongan.getNamaPerusahaan());
                System.out.println("Kualifikasi: " + lowongan.getKualifikasi());
            }
            System.out.println("-------------------");
        }
    }

   
    public void applyJob(IMenu menu) {
        if (menu.semuaLowongan.isEmpty()) {
            System.out.println("Tidak ada lowongan yang tersedia.");
            return;
        }

        if (resumes.isEmpty()) {
            System.out.println("Anda belum memiliki resume. Tambahkan resume terlebih dahulu sebelum melamar.");
            return;
        }

        
        System.out.println("\n=== Daftar Lowongan ===");
        for (Lowongan lowongan : menu.semuaLowongan) {
            lowongan.tampilkanLowongan();
            System.out.println("-------------------");
        }

        
        System.out.print("Masukkan ID Lowongan yang ingin dilamar: ");
        int idLowongan = scanner.nextInt();
        scanner.nextLine(); 

        
        Lowongan targetLowongan = null;
        for (Lowongan lowongan : menu.semuaLowongan) {
            if (lowongan.getIdLowongan() == idLowongan) {
                targetLowongan = lowongan;
                break;
            }
        }

        if (targetLowongan == null) {
            System.out.println("ID Lowongan tidak valid.");
            return;
        }

        
        System.out.println("\n=== Daftar Resume ===");
        for (Resume resume : resumes) {
            System.out.println("ID Resume: " + resume.getIdDokumen());
        }

        
        System.out.print("Masukkan ID Resume yang ingin digunakan: ");
        int idResume = scanner.nextInt();
        scanner.nextLine(); 

        
        boolean resumeValid = false;
        for (Resume resume : resumes) {
            if (resume.getIdDokumen() == idResume) {
                resumeValid = true;
                break;
            }
        }

        if (!resumeValid) {
            System.out.println("ID Resume tidak valid.");
            return;
        }

        
        System.out.println("Masukkan tanggal hari ini: ");
        String tanggalLamaran = scanner.nextLine(); 
        Lamaran lamaranBaru = new Lamaran(idLamaranCounter++, idLowongan, this.getIdPengguna(), idResume, tanggalLamaran, "Dalam Proses");
        daftarLamaran.add(lamaranBaru);
        targetLowongan.addLamaran(lamaranBaru);
        
        AdminPerusahaan admin = targetLowongan.getAdminPerusahaan();
        if (admin != null) {
            String pesanNotifikasi = "Pelamar ID " + this.getIdPengguna() + " telah melamar untuk posisi " 
                                     + targetLowongan.getPosisi() + ". Email: " + this.getEmail();
            Notifikasi notifikasi = new Notifikasi(admin.getIdPengguna(), pesanNotifikasi, tanggalLamaran);
            admin.tambahNotifikasi(notifikasi);
        }



        System.out.println("Lamaran berhasil diajukan dengan ID: " + lamaranBaru.getIdLamaran());
    }
    
    public void updateStatusLamaran(int idLamaran, String statusBaru) {
        for (Lamaran lamaran : daftarLamaran) {
            if (lamaran.getIdLamaran() == idLamaran) {
                lamaran.setStatusLamaran(statusBaru);
                System.out.println("Status lamaran ID " + idLamaran + " berhasil diupdate menjadi: " + statusBaru);
                return;
            }
        }
        System.out.println("Lamaran dengan ID " + idLamaran + " tidak ditemukan.");
    }
    
    @Override
    public void showInfoPengguna(){
        System.out.println("======Informasi Pelamar======");
        System.out.println("ID pelamar\t:" + getIdPengguna());
        System.out.println("Username\t:" + getUsername());
        System.out.println("Role\t\t:" + getRole());
        System.out.println("Email\t\t:" +getEmail());
    }
     
    public void tambahNotifikasi(Notifikasi notifikasi) {
        daftarNotifikasi.add(notifikasi);
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
    public void showRecommendation(){
        System.out.println("Coming Soon....");
    }
    
}