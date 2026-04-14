package tugas;

import java.util.Scanner;

public class PembelianKopiImproved {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            int pilihanKopi, pilihanSize, jumlah;
            int hargaKopi = 0;
            int tambahanSize = 0;
            int total;

            String namaKopi = "";
            String namaSize = "";

            System.out.println("=== Menu Kopi ===");
            System.out.println("1. Espresso  (Rp20000)");
            System.out.println("2. Cappuccino (Rp25000)");
            System.out.println("3. Latte     (Rp30000)");
            System.out.print("Pilih kopi (1-3): ");
            pilihanKopi = input.nextInt();

            // Switch kopi
            switch (pilihanKopi) {
                case 1:
                    namaKopi = "Espresso";
                    hargaKopi = 20000;
                    break;
                case 2:
                    namaKopi = "Cappuccino";
                    hargaKopi = 25000;
                    break;
                case 3:
                    namaKopi = "Latte";
                    hargaKopi = 30000;
                    break;
                default:
                    System.out.println("Pilihan kopi tidak valid!");
                    return;
            }

            System.out.println("\n=== Pilihan Size ===");
            System.out.println("1. Demi   (+0)");
            System.out.println("2. Short  (+5000)");
            System.out.println("3. Tall   (+10000)");
            System.out.println("4. Grande (+15000)");
            System.out.println("5. Venti  (+20000)");
            System.out.println("6. Trenta (+25000)");
            System.out.print("Pilih size (1-6): ");
            pilihanSize = input.nextInt();

            // Switch size
            switch (pilihanSize) {
                case 1:
                    namaSize = "Demi";
                    tambahanSize = 0;
                    break;
                case 2:
                    namaSize = "Short";
                    tambahanSize = 5000;
                    break;
                case 3:
                    namaSize = "Tall";
                    tambahanSize = 10000;
                    break;
                case 4:
                    namaSize = "Grande";
                    tambahanSize = 15000;
                    break;
                case 5:
                    namaSize = "Venti";
                    tambahanSize = 20000;
                    break;
                case 6:
                    namaSize = "Trenta";
                    tambahanSize = 25000;
                    break;
                default:
                    System.out.println("Pilihan size tidak valid!");
                    return;
            }

            System.out.print("\nMasukkan jumlah: ");
            jumlah = input.nextInt();

            int hargaSatuan = hargaKopi + tambahanSize;
            total = hargaSatuan * jumlah;

            // Diskon
            if (total >= 100000) {
                System.out.println("Kamu mendapat diskon 15%");
                total -= total * 15 / 100;
            } else if (total >= 50000) {
                System.out.println("Kamu mendapat diskon 10%");
                total -= total * 10 / 100;
            } else {
                System.out.println("Tidak ada diskon");
            }

            // Output
            System.out.println("\n=== Struk Pembelian ===");
            System.out.println("Kopi   : " + namaKopi);
            System.out.println("Size   : " + namaSize);
            System.out.println("Jumlah : " + jumlah);
            System.out.println("Total  : Rp" + total);
        }
    }
}