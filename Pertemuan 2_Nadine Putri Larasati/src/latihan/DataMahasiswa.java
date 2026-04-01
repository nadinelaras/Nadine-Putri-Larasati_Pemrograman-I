package latihan;

import java.util.Scanner;

public class DataMahasiswa {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String nama;
        String nim;
        String programStudi;

        System.out.print("Input Nama: ");
        nama = input.nextLine();

        System.out.print("Input NIM: ");
        nim = input.nextLine();

        System.out.print("Input Program Studi: ");
        programStudi = input.nextLine();

        System.out.println("\nData Mahasiswa:");
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Program Studi: " + programStudi);

        input.close();
    }
}