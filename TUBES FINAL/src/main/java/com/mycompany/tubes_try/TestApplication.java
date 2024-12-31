/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// V.2 
// Penambahan fitur ApplyJob
package com.mycompany.tubes_try;

/**
 *
 * @author nhqkb
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new IMenu();
        

        // Loop utama untuk menampilkan menu berulang kali
        while (true) {
            menu.menuUtama();
            System.out.print(">>Masukkan pilihan: ");
            try{
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer
            switch (pilihan) {
                case 1:
                    menu.Login();
                    break;
                case 2:
                    menu.Daftar();
                    break;
                case 3:
                    menu.ShowAllAccount();
                    break;
                case 0:
                    System.out.println("Keluar dari Aplikasi. Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
            }catch(InputMismatchException e){
                System.out.println("Format inputan tidak valid, silahkan coba lagi !");
                scanner.nextLine();
            }
        }   
                
        
    } 
    
}




