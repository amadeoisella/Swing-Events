package swingtax;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class swingTax {
    private JButton calculate;
    private JPanel taxPanel;
    private JTextField price;
    private JTextField tax;
    private JTextField total;


    public swingTax() {
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String priceText = price.getText().trim();
                String taxText = tax.getText().trim();

                if (!priceText.isEmpty() && !taxText.isEmpty()) {
                    double p = Double.parseDouble(priceText);
                    double t = Double.parseDouble(taxText);

                    double result = p + (p / 100 * t);
                    total.setText(Double.toString(result));
                } else {
                    // Manejo del caso en que los campos estén vacíos o contengan solo espacios en blanco
                    total.setText("Error: Campos vacíos");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SwingTax");
        frame.setContentPane(new swingTax().taxPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
