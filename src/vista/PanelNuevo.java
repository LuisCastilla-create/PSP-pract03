package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelNuevo extends JPanel {
    private JTextField txtNumero = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtPuntos = new JTextField();
    private JTextField txtFecha = new JTextField();
    private JLabel lblError = new JLabel(" ");
    private JButton btnGuardar = new JButton("Guardar cliente");

    public PanelNuevo() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel campos = new JPanel(new GridLayout(4, 2, 10, 10));
        campos.add(new JLabel("Número:"));
        campos.add(txtNumero);
        campos.add(new JLabel("Nombre:"));
        campos.add(txtNombre);
        campos.add(new JLabel("Puntos (0-1000):"));
        campos.add(txtPuntos);
        campos.add(new JLabel("Nacimiento (dd/MM/aaaa):"));
        campos.add(txtFecha);
        lblError.setForeground(Color.RED);
        JPanel inferior = new JPanel(new GridLayout(2, 1, 5, 5));
        inferior.add(lblError);
        inferior.add(btnGuardar);
        add(new JLabel("Nuevo cliente"), BorderLayout.NORTH);
        add(campos, BorderLayout.CENTER);
        add(inferior, BorderLayout.SOUTH);
    }

    public String getNumero() { return txtNumero.getText(); }
    public String getNombre() { return txtNombre.getText(); }
    public String getPuntos() { return txtPuntos.getText(); }
    public String getFecha() { return txtFecha.getText(); }
    public void mostrarError(String mensaje) { lblError.setText(mensaje); }
    public void addGuardarListener(ActionListener l) { btnGuardar.addActionListener(l); }

    public void limpiar() {
        txtNumero.setText("");
        txtNombre.setText("");
        txtPuntos.setText("");
        txtFecha.setText("");
        lblError.setText(" ");
    }
}
