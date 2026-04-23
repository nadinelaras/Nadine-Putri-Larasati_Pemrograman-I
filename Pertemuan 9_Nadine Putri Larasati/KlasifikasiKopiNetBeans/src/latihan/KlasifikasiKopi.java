/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

import javax.swing.*;
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

// Class Arabika
class Arabika extends BijiKopi implements Penilaian {

    public Arabika(String nama, double berat) {
        super(nama, berat);
    }

    @Override
    String klasifikasi() {
        return "Arabika";
    }

    @Override
    public String kualitas() {
        return (berat >= 10) ? "Baik" : "Cukup";
    }
}

// Class Robusta
class Robusta extends BijiKopi implements Penilaian {

    public Robusta(String nama, double berat) {
        super(nama, berat);
    }

    @Override
    String klasifikasi() {
        return "Robusta";
    }

    @Override
    public String kualitas() {
        return (berat >= 8) ? "Baik" : "Rendah";
    }
}

/**
 *
 * @author nadin
 */
public class KlasifikasiKopi {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Klasifikasi Kopi (Latihan)");
        frame.setSize(350, 280);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel lblNama = new JLabel("Nama:");
        lblNama.setBounds(20, 20, 100, 25);
        frame.add(lblNama);

        JTextField txtNama = new JTextField();
        txtNama.setBounds(120, 20, 180, 25);
        frame.add(txtNama);

        JLabel lblBerat = new JLabel("Berat:");
        lblBerat.setBounds(20, 60, 100, 25);
        frame.add(lblBerat);

        JTextField txtBerat = new JTextField();
        txtBerat.setBounds(120, 60, 180, 25);
        frame.add(txtBerat);

        JLabel lblJenis = new JLabel("Jenis:");
        lblJenis.setBounds(20, 100, 100, 25);
        frame.add(lblJenis);

        String[] jenis = {"Arabika", "Robusta"};
        JComboBox<String> combo = new JComboBox<>(jenis);
        combo.setBounds(120, 100, 180, 25);
        frame.add(combo);

        JButton btn = new JButton("Proses");
        btn.setBounds(120, 140, 100, 30);
        frame.add(btn);

        JTextArea hasil = new JTextArea();
        hasil.setBounds(20, 180, 300, 60);
        frame.add(hasil);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = txtNama.getText();
                    double berat = Double.parseDouble(txtBerat.getText());
                    String jenis = combo.getSelectedItem().toString();

                    BijiKopi kopi;

                    if (jenis.equals("Arabika")) {
                        kopi = new Arabika(nama, berat);
                    } else {
                        kopi = new Robusta(nama, berat);
                    }

                    Penilaian nilai = (Penilaian) kopi;

                    hasil.setText(
                        "Nama: " + nama +
                        "\nJenis: " + kopi.klasifikasi() +
                        "\nKualitas: " + nilai.kualitas()
                    );

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Input salah!");
                }
            }
        });

        frame.setVisible(true);
    }
}
