package estacionamientoticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;

public class Ingreso_de_Datos extends JFrame {
    private JTextField nombreField;
    private JTextField modeloField;
    private JTextField colorField;
    private JTextField placasField;
    private JTextField añoField;
    private Color colorfra;

    /**
     * 
     * @author Dafne,Rodrigo,Julio,Cesar
     */

    public Ingreso_de_Datos() {
        setTitle("Generador de Ticket");
        colorfra =  new Color(135, 252, 190);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
       


        JLabel txt1 = new JLabel("Primer nombre: ");
        txt1.setFont(new Font("Agency FB", Font.BOLD,15));
        panel.add(txt1);
        txt1.setBounds(100, 20, 150, 10);
        nombreField = new JTextField();
        nombreField.setBounds(200, 10, 150, 30);
        panel.add(nombreField);

        JLabel txt2 = new JLabel("Modelo del carro: ");
        txt2.setFont(new Font("Agency FB", Font.BOLD,15));
        panel.add(txt2);
        txt2.setBounds(90, 90, 150, 10);
        modeloField = new JTextField();
        modeloField.setBounds(200, 80, 150, 30);
        panel.add(modeloField);

        JLabel txt3 = new JLabel("Color: ");
        txt3.setFont(new Font("Agency FB", Font.BOLD,15));
        panel.add(txt3);
        txt3.setBounds(130, 160, 150, 10);
        colorField = new JTextField();
        colorField.setBounds(200, 150, 150, 30);
        panel.add(colorField);

        JLabel txt4 = new JLabel("Placas: ");
        txt4.setFont(new Font("Agency FB", Font.BOLD,15));
        panel.add(txt4);
        txt4.setBounds(120, 230, 150, 10);
        placasField = new JTextField();
        placasField.setBounds(200, 220, 150, 30);
        panel.add(placasField);

        JLabel txt5 = new JLabel("Año: ");
        txt5.setFont(new Font("Agency FB", Font.BOLD,15));
        panel.add(txt5);
        txt5.setBounds(130, 300, 150, 10);
        añoField = new JTextField();
        añoField.setBounds(200, 290, 150, 30);
        panel.add(añoField);

        JButton generarButton = new JButton("Generar Ticket");
        generarButton.setBounds(150, 350, 150, 50);
        generarButton.setBackground(Color.cyan);
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarTicket();
            }
        });
        panel.add(generarButton);
        panel.setBackground(colorfra);
        add(panel);
    }

    private void generarTicket() {
        String nombre = nombreField.getText();
        String modelo = modeloField.getText();
        String color = colorField.getText();
        String placas = placasField.getText();
        String año = añoField.getText();
        String fechaHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String ticket = String.format("                      "
                + "Estacionamiento Rocket"
                + "\n****************************************************"
                + "\n                     "
                + "\n                     "
                + "Plaza Rocket Ixtapaluca, Mex"
                + "\n\tNombre: %s \n\tModelo: %s\n\tColor: %s\n\tPlacas: %s\n\tAño: %s\n"
                + "             Fecha y Hora: %s "
                + "\n                                       "
                + "\n****************************************************",
                nombre, modelo, color, placas, año, fechaHora);

        // Mostrar el ticket en una nueva ventana
        JFrame ticketFrame = new JFrame("Ticket Generado");
        ticketFrame.setSize(400, 300);
        colorfra =  new Color(135, 252, 190);
        ticketFrame.setLocationRelativeTo(null);
        ticketFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea ticketArea = new JTextArea(ticket);
        ticketArea.setEditable(false);
        ticketArea.setBackground(colorfra);
        ticketFrame.add(new JScrollPane(ticketArea));
        ticketFrame.setVisible(true);

        ticketFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                JOptionPane.showMessageDialog(null, "\tBienvenido a Plaza Rocket" + "\nTe atendió Rodrigo Reyna");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ingreso_de_Datos().setVisible(true);
            }
        });
    }
}
