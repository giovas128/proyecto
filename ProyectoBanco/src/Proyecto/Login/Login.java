package Proyecto.Login;

import Proyecto.menu.Menu;
import java.awt.Image;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
/**
 *
 * @author Cesar, Rodrigo, Dafne, Julio
 */

public class Login extends JFrame implements ActionListener {
    JButton salir, ingresar, nuevoUsuario;
    JTextField user, pin;
    JLabel et1, et2;
    String opcion, deposito, retiro;
    int saldo;
    Color colorfra;
    JLabel logoServ, nomServ;

    HashMap<String, String> userPinMap;
    final String DATA_FILE = "user_data.txt";

    public Login() {
        userPinMap = new HashMap<>();
        loadUserData();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(500, 600);
        setLocationRelativeTo(null);

        colorfra = new Color(1, 22, 193);

        ImageIcon fondo = new ImageIcon("");
        JLabel j1Fondo = new JLabel(fondo);
        j1Fondo.setBounds(0, 50, 500, 500);

        ImageIcon img = new ImageIcon("img/logo.jpeg");
        Image image = img.getImage();

        Image newimg = image.getScaledInstance(160, 160, java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        logoServ = new JLabel(img);
        JLabel logoImg = new JLabel(img);
        logoImg.setBounds(150, 20, 230, 150);

        ImageIcon us = new ImageIcon("");
        JLabel j1User = new JLabel(us);
        j1User.setBounds(30, 150, 90, 140);

        JLabel txtUser = new JLabel("USUARIO");
        txtUser.setForeground(Color.white);
        txtUser.setBounds(130, 190, 80, 20);
        user = new JTextField();
        user.setBounds(130, 220, 270, 40);

        ImageIcon imgPin = new ImageIcon("");
        JLabel j1Pin = new JLabel(imgPin);
        j1Pin.setBounds(30, 340, 90, 90);

        JLabel txtPin = new JLabel("PIN");
        txtPin.setForeground(Color.white);
        txtPin.setBounds(130, 340, 90, 20);

        pin = new JTextField();
        pin.setBounds(130, 370, 270, 40);

        et1 = new JLabel();
        et1.setBounds(410, 220, 32, 32);

        et2 = new JLabel();
        et2.setBounds(410, 325, 32, 32);

        Color verde = new Color(102, 255, 102);
        Color rojo = new Color(255, 102, 102);

        salir = new JButton("salir");
        salir.setBounds(80, 480, 100, 50);
        salir.addActionListener(this);
        salir.setBackground(rojo);

        ingresar = new JButton("ingresar");
        ingresar.setBounds(200, 480, 100, 50);
        ingresar.addActionListener(this);
        ingresar.setBackground(verde);

        nuevoUsuario = new JButton("Nuevo Usuario");
        nuevoUsuario.setBounds(320, 480, 140, 50);
        nuevoUsuario.addActionListener(this);
        nuevoUsuario.setBackground(verde);

        JPanel ventana = new JPanel();
        ventana.setLayout(null);
        ventana.setSize(500, 600);

        ventana.add(et2);
        ventana.add(et1);
        ventana.add(ingresar);
        ventana.add(salir);
        ventana.add(nuevoUsuario);
        ventana.add(j1Pin);
        ventana.add(j1User);
        ventana.add(txtPin);
        ventana.add(pin);
        ventana.add(txtUser);
        ventana.add(user);
        ventana.add(logoImg);
        ventana.add(j1Fondo);
        ventana.setBackground(colorfra);
        add(ventana);
        setVisible(true);
    }

    private void loadUserData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    userPinMap.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading user data: " + e.getMessage());
        }
    }

    private void saveUserData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (String user : userPinMap.keySet()) {
                writer.write(user + ":" + userPinMap.get(user));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving user data: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent accion) {
        if (accion.getSource() == salir) {
            System.exit(0);
        }
        if (accion.getSource() == ingresar) {
            String userS = user.getText();
            String pinS = pin.getText();
            if (userPinMap.containsKey(userS) && userPinMap.get(userS).equals(pinS)) {
                ImageIcon user1 = new ImageIcon("");
                et1.setIcon(user1);
                ImageIcon user2 = new ImageIcon("");
                et2.setIcon(user2);
                JOptionPane.showMessageDialog(null, "Datos Correctos", "Acceso", JOptionPane.INFORMATION_MESSAGE);
                new Menu().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o PIN incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (accion.getSource() == nuevoUsuario) {
            String userS = user.getText();
            String pinS = pin.getText();
            if (!userPinMap.containsKey(userS)) {
                userPinMap.put(userS, pinS);
                saveUserData();
                JOptionPane.showMessageDialog(null, "Nuevo usuario agregado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
