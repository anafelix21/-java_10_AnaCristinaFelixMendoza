package actividad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField pantalla;
    private double num1, num2, resultado;
    private String operador;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        pantalla = new JTextField();
        pantalla.setFont(new Font("Arial", Font.BOLD, 24));
        pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
        pantalla.setEditable(false); // No se escribe directamente
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 4, 10, 10)); // Aumentamos a 5 filas

        String[] botones = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Botón para borrar
        };

        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(this);
            panelBotones.add(boton);
        }

        add(panelBotones, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("0123456789.".contains(comando)) {
            pantalla.setText(pantalla.getText() + comando);
        } else if ("+-*/".contains(comando)) {
            num1 = Double.parseDouble(pantalla.getText());
            operador = comando;
            pantalla.setText("");
        } else if ("=".equals(comando)) {
            num2 = Double.parseDouble(pantalla.getText());
            switch (operador) {
                case "+": resultado = num1 + num2; break;
                case "-": resultado = num1 - num2; break;
                case "*": resultado = num1 * num2; break;
                case "/": resultado = num1 / num2; break;
            }
            pantalla.setText(String.valueOf(resultado));
        } else if ("C".equals(comando)) {
            pantalla.setText("");  // Limpia todo
            num1 = num2 = resultado = 0;
            operador = null;
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}