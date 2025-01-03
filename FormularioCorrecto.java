import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioEvento extends JFrame implements ActionListener {
    private JLabel nombreDelContribuyente;
    private JTextField nombreUsuario1;
    private JLabel nombreDeLaContribuyente;
    private JTextField nombreUsuario2;
    private JButton ingresarButton;
    private JLabel pregunta1Label;
    private JComboBox<String> respuesta1;
    private JLabel pregunta2Label;
    private JComboBox<String> respuesta2;
    private JLabel pregunta3Label;
    private JComboBox<String> respuesta3;
    private JLabel pregunta4Label;
    private JComboBox<String> respuesta4;
    private JLabel pregunta5Label;
    private JComboBox<String> respuesta5;
    private JLabel pregunta6Label;
    private JComboBox<String> respuesta6;
    private JButton enviarButton;

    public FormularioEvento() {
        // Configurar la ventana principal
        setTitle("Formulario de la boda catolica");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2)); // Utiliza un GridLayout para organizar los componentes.
        // Componentes del formulario
        String si = "Si";
        String no = "No";
        nombreDelContribuyente = new JLabel("Nombre completo del contrayente:");
        nombreUsuario1 = new JTextField(20);
        nombreDeLaContribuyente = new JLabel("Nombre completo de la contrayente:");
        nombreUsuario2 = new JTextField(20);
        pregunta1Label = new JLabel("¿Tienen su Fe de bautismo actualizada de ambas partes?");
        String[] opcion1 = {si,no};
        pregunta2Label = new JLabel("¿Tienen su Acta de confirmacion?");
        String[] opcion2 = {si,no};
        pregunta3Label = new JLabel("¿Tienen su acta de la primera comunion?");
        String[] opcion3 = {si,no};
        pregunta4Label = new JLabel("¿Tienen su acta de nacimiento?");
        String[] opcion4 = {si,no};
        pregunta5Label = new JLabel("¿Tiene a sus 4 testigos?");
        String[] opcion5 = {si,no};
        pregunta6Label = new JLabel("¿Alguno es de otra religion o pais?");
        String[] opcion6 = {si,no};
        ingresarButton = new JButton("Ingresar");
        respuesta1 = new JComboBox<>(opcion1);
        respuesta2 = new JComboBox<>(opcion2);
        respuesta3 = new JComboBox<>(opcion3);
        respuesta4 = new JComboBox<>(opcion4);
        respuesta5 = new JComboBox<>(opcion5);
        respuesta6 = new JComboBox<>(opcion6);
        enviarButton = new JButton("Enviar");

        // Agregar componentes a la ventana
        add(nombreDelContribuyente);
        add(nombreUsuario1);
        add(nombreDeLaContribuyente);
        add(nombreUsuario2);
        add(pregunta1Label);
        add(respuesta1);
        add(pregunta2Label);
        add(respuesta2);
        add(pregunta3Label);
        add(respuesta3);
        add(pregunta4Label);
        add(respuesta4);
        add(pregunta5Label);
        add(respuesta5);
        add(pregunta6Label);
        add(respuesta6);
        add(ingresarButton);
        add(enviarButton);
        // Configurar ActionListener para el botón "Ingresar"
        ingresarButton.addActionListener(this);
        enviarButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviarButton) {
            // Realizar acciones cuando se presiona el botón "Ingresar"
            String nombre1 = nombreUsuario1.getText();
            String nombre2 = nombreUsuario2.getText();
            JOptionPane.showMessageDialog(this, "Señor " + nombre1 + " y señora " + nombre2 + " .Tienen los datos necesarios para casarse en la iglesia catolica, su cita sera el 18/04/2024 a las 10:30am");

        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FormularioEvento formulario = new FormularioEvento();
            formulario.setVisible(true);
        });
    }
}