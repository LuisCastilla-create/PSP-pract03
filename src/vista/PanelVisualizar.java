package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelVisualizar extends JPanel {
    private JLabel lblPosicion = new JLabel("", SwingConstants.CENTER);
    private JLabel lblNumero = new JLabel();
    private JLabel lblNombre = new JLabel();
    private JLabel lblPuntos = new JLabel();
    private JLabel lblFecha = new JLabel();
    private JButton btnPrimero = new JButton("Primero");
    private JButton btnAnterior = new JButton("Anterior");
    private JButton btnSiguiente = new JButton("Siguiente");
    private JButton btnUltimo = new JButton("Último");
    private JButton btnBorrar = new JButton("Borrar");
    private JButton btnOrdenar = new JButton("Ordenar por número");

    public PanelVisualizar() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel datos = new JPanel(new GridLayout(4, 2, 10, 10));
        datos.add(new JLabel("Número:"));
        datos.add(lblNumero);
        datos.add(new JLabel("Nombre:"));
        datos.add(lblNombre);
        datos.add(new JLabel("Puntos:"));
        datos.add(lblPuntos);
        datos.add(new JLabel("Fecha de nacimiento:"));
        datos.add(lblFecha);

        JPanel navegacion = new JPanel(new FlowLayout());
        navegacion.add(btnPrimero);
        navegacion.add(btnAnterior);
        navegacion.add(btnSiguiente);
        navegacion.add(btnUltimo);
        JPanel acciones = new JPanel(new FlowLayout());
        acciones.add(btnBorrar);
        acciones.add(btnOrdenar);
        JPanel botones = new JPanel(new GridLayout(2, 1));
        botones.add(navegacion);
        botones.add(acciones);
        add(lblPosicion, BorderLayout.NORTH);
        add(datos, BorderLayout.CENTER);
        add(botones, BorderLayout.SOUTH);
    }

    public void mostrarCliente(String numero, String nombre, String puntos,
            String fecha, int posicion, int total) {
        lblNumero.setText(numero);
        lblNombre.setText(nombre);
        lblPuntos.setText(puntos);
        lblFecha.setText(fecha);
        if (total == 0) {
            lblPosicion.setText("No hay clientes");
        } else {
            lblPosicion.setText("Cliente " + posicion + " de " + total);
        }
    }

    public void setBotones(boolean retroceder, boolean avanzar, boolean hayClientes) {
        btnPrimero.setEnabled(retroceder);
        btnAnterior.setEnabled(retroceder);
        btnSiguiente.setEnabled(avanzar);
        btnUltimo.setEnabled(avanzar);
        btnBorrar.setEnabled(hayClientes);
        btnOrdenar.setEnabled(hayClientes);
    }

    public void addPrimeroListener(ActionListener l) { btnPrimero.addActionListener(l); }
    public void addAnteriorListener(ActionListener l) { btnAnterior.addActionListener(l); }
    public void addSiguienteListener(ActionListener l) { btnSiguiente.addActionListener(l); }
    public void addUltimoListener(ActionListener l) { btnUltimo.addActionListener(l); }
    public void addBorrarListener(ActionListener l) { btnBorrar.addActionListener(l); }
    public void addOrdenarListener(ActionListener l) { btnOrdenar.addActionListener(l); }
}
