package latihan;

import java.util.Scanner;

public class PembelianKopi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int pilihanKopi, jumlah;
        int harga = 0;
        int total;

        System.out.println("=== Menu Kopi ===");
        System.out.println("1. Espresso  (Rp20000)");
        System.out.println("2. Cappuccino (Rp25000)");
        System.out.println("3. Latte     (Rp30000)");
        System.out.print("Pilih kopi (1-3): ");
        pilihanKopi = input.nextInt();

        // Switch untuk menentukan harga
        switch (pilihanKopi) {
            case 1:
                harga = 20000;
                break;
            case 2:
                harga = 25000;
                break;
            case 3:
                harga = 30000;
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                input.close();
                return;
        }

        System.out.print("Masukkan jumlah: ");
        jumlah = input.nextInt();

        total = harga * jumlah;

        // If-else untuk diskon
        if (total >= 50000) {
            System.out.println("Kamu mendapat diskon 10%");
            total = total - (total * 10 / 100);
        } else {
            System.out.println("Tidak ada diskon");
        }

        System.out.println("Total yang harus dibayar: Rp" + total);

        input.close();
    }
}