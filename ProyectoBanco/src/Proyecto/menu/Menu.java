package Proyecto.menu;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

public class Menu extends JFrame implements ActionListener {
    Color colorfra;
    JPanel panel;
    JButton btnDeposito, btnRetiro, btnSalir;
    
    public Menu() {
        setTitle("Menú Principal");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iniciarComponentes();
    }
    
    private void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        colorfra = new Color(1, 22, 193);
        
        btnDeposito = new JButton("Depositar");
        btnDeposito.setBounds(100, 50, 200, 50);
        btnDeposito.setBackground(Color.BLUE);
        btnDeposito.setForeground(Color.WHITE);
        btnDeposito.setFont(new Font("Arial", Font.BOLD, 20));
        btnDeposito.addActionListener(this);
        
        btnRetiro = new JButton("Retirar");
        btnRetiro.setBounds(100, 120, 200, 50);
        btnRetiro.setBackground(Color.BLUE);
        btnRetiro.setForeground(Color.WHITE);
        btnRetiro.setFont(new Font("Arial", Font.BOLD, 20));
        btnRetiro.addActionListener(this);
        
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 190, 200, 50);
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);
        btnSalir.setFont(new Font("Arial", Font.BOLD, 20));
        btnSalir.addActionListener(this);
        
        panel.add(btnDeposito);
        panel.add(btnRetiro);
        panel.add(btnSalir);
        panel.setBackground(colorfra);
        
        add(panel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDeposito) {
            this.setVisible(true);
            new Deposito().setVisible(true);
        } else if (e.getSource() == btnRetiro) {
            this.setVisible(true);
            new Retiro().setVisible(true);
        } else if (e.getSource() == btnSalir) {
            System.exit(0);
        }
    }
    
    public void Menu() {
        new Menu().setVisible(true);
    }
    
    public static void main(String[] args) {
        new Menu().setVisible(true);
    }
}
