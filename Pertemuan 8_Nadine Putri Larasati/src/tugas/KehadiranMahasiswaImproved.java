package tugas;

import java.util.Scanner;

public class KehadiranMahasiswaImproved {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            boolean ulang = true;

            while (ulang) {
                int sks;
                int totalPertemuan = 0;

                // do-while
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

                // while
                while (true) {
                    System.out.print("Masukkan jumlah kehadiran (0 - " + totalPertemuan + "): ");
                    hadir = input.nextInt();

                    if (hadir >= 0 && hadir <= totalPertemuan) {
                        break;
                    } else {
                        System.out.println("Input tidak valid!");
                    }
                }

                int tidakHadir = totalPertemuan - hadir;

                // for
                System.out.println("\n=== Rekap Kehadiran ===");
                for (int i = 1; i <= totalPertemuan; i++) {
                    if (i <= hadir) {
                        System.out.println("Pertemuan ke-" + i + " : Hadir");
                    } else {
                        System.out.println("Pertemuan ke-" + i + " : Tidak Hadir");
                    }
                }

                double persen = (double) hadir / totalPertemuan * 100;

                System.out.println("\nTotal Pertemuan : " + totalPertemuan);
                System.out.println("Hadir           : " + hadir);
                System.out.println("Tidak Hadir     : " + tidakHadir);
                System.out.printf("Persentase      : %.2f%%\n", persen);

                // if-else
                if (persen < 75) {
                    System.out.println("Status: Kehadiran kurang dari 75%");
                } else {
                    System.out.println("Status: Memenuhi syarat kehadiran");
                }

                // tambahan kategori nilai
                if (persen >= 90) {
                    System.out.println("Kategori: Sangat Baik");
                } else if (persen >= 75) {
                    System.out.println("Kategori: Baik");
                } else if (persen >= 60) {
                    System.out.println("Kategori: Cukup");
                } else {
                    System.out.println("Kategori: Kurang");
                }

                // pilihan ulang (do-while)
                char pilihan;
                do {
                    System.out.print("\nIngin input lagi? (y/n): ");
                    pilihan = input.next().charAt(0);

                    if (pilihan != 'y' && pilihan != 'n') {
                        System.out.println("Input tidak valid!");
                    }
                } while (pilihan != 'y' && pilihan != 'n');

                if (pilihan == 'n') {
                    ulang = false;
                    System.out.println("Program selesai.");
                }
            }
        }
    }
}