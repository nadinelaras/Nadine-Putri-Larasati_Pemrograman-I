/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Interface
interface Penilaian {
    String kualitas();
}

// Abstract Class
abstract class BijiKopi {
    protected String nama;
    protected double berat;

    public BijiKopi(String nama, double berat) {
        this.nama = nama;
        this.berat = berat;
    }

    abstract String klasifikasi();
}

// Arabika
class Arabika extends BijiKopi implements Penilaian {

    public Arabika(String nama, double berat) {
        super(nama, berat);
    }

    @Override
    String klasifikasi() {
        return "Arabika (Premium)";
    }

    @Override
    public String kualitas() {
        if (berat >= 12) return "Grade A";
        else if (berat >= 10) return "Grade B";
        else return "Grade C";
    }
}

// Robusta
class Robusta extends BijiKopi implements Penilaian {

    public Robusta(String nama, double berat) {
        super(nama, berat);
    }

    @Override
    String klasifikasi() {
        return "Robusta (Komersial)";
    }

    @Override
    public String kualitas() {
        if (berat >= 10) return "Grade A";
        else if (berat >= 8) return "Grade B";
        else return "Grade C";
    }
}

/**
 *
 * @author nadin
 */
public class KlasifikasiKopiImproved {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Klasifikasi Biji Kopi - Improved");
        frame.setSize(420, 320);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblNama = new JLabel("Nama Kopi:");
        JTextField txtNama = new JTextField();

        JLabel lblBerat = new JLabel("Berat (gram):");
        JTextField txtBerat = new JTextField();

        JLabel lblJenis = new JLabel("Jenis Kopi:");
        String[] jenis = {"Arabika", "Robusta"};
        JComboBox<String> comboJenis = new JComboBox<>(jenis);

        JButton btnProses = new JButton("Proses");
        JButton btnReset = new JButton("Reset");

        JTextArea hasil = new JTextArea();
        hasil.setEditable(false);

        // Tambahkan ke frame
        frame.add(lblNama);
        frame.add(txtNama);
        frame.add(lblBerat);
        frame.add(txtBerat);
        frame.add(lblJenis);
        frame.add(comboJenis);
        frame.add(btnProses);
        frame.add(btnReset);
        frame.add(new JLabel("Hasil:"));
        frame.add(new JScrollPane(hasil));

        // Event Proses
        btnProses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = txtNama.getText().trim();
                    String beratText = txtBerat.getText().trim();

                    if (nama.isEmpty() || beratText.isEmpty()) {
                        throw new Exception("Field tidak boleh kosong!");
                    }

                    double berat = Double.parseDouble(beratText);
                    if (berat <= 0) {
                        throw new Exception("Berat harus lebih dari 0!");
                    }

                    String jenisDipilih = comboJenis.getSelectedItem().toString();

                    BijiKopi kopi;
                    if (jenisDipilih.equals("Arabika")) {
                        kopi = new Arabika(nama, berat);
                    } else {
                        kopi = new Robusta(nama, berat);
                    }

                    Penilaian nilai = (Penilaian) kopi;

                    hasil.setText(
                        "=== HASIL KLASIFIKASI ===\n" +
                        "Nama Kopi   : " + nama + "\n" +
                        "Jenis       : " + kopi.klasifikasi() + "\n" +
                        "Berat       : " + berat + " gram\n" +
                        "Kualitas    : " + nilai.kualitas()
                    );

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Berat harus angka!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Event Reset
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                txtBerat.setText("");
                hasil.setText("");
                comboJenis.setSelectedIndex(0);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
