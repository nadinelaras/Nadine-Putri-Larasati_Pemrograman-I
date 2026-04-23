package latihan;

import java.util.Scanner;

public class KehadiranMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sks;
        int totalPertemuan = 0;

        // do-while untuk pilih SKS
        do {
            System.out.print("Masukkan jumlah SKS (2 / 3): ");
            sks = input.nextInt();

            if (sks == 3) {
                totalPertemuan = 21;
            } else if (sks == 2) {
                totalPertemuan = 14;
            } else {
                System.out.println("Input tidak valid! Pilih 2 atau 3.");
            }
        } while (sks != 2 && sks != 3);

        int hadir;

        // while untuk validasi input jumlah hadir
        while (true) {
            System.out.print("Masukkan jumlah kehadiran (0 - " + totalPertemuan + "): ");
            hadir = input.nextInt();

            if (hadir >= 0 && hadir <= totalPertemuan) {
                break;
            } else {
                System.out.println("Input tidak valid!");
            }
        }

        // for untuk rekap
        System.out.println("\n=== Rekap Pertemuan ===");
        for (int j = 1; j <= totalPertemuan; j++) {
            System.out.println("Pertemuan ke-" + j);
        }

        double persen = (double) hadir / totalPertemuan * 100;

        System.out.println("\nTotal hadir: " + hadir + " dari " + totalPertemuan);
        System.out.println("Persentase kehadiran: " + persen + "%");

        // if-else untuk keputusan
        if (persen < 75) {
            System.out.println("Kehadiran kurang dari 75%");
        } else {
            double nilaiKehadiran = persen;
            System.out.println("Nilai kehadiran: " + nilaiKehadiran);
        }

        input.close();
    }
}