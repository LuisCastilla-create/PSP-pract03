package vista;

import java.awt.event.ActionListener;
import javax.swing.*;

public class VistaClientes extends JFrame {

    // Las tres opciones del menú.
    private JMenuItem visualizar = new JMenuItem("Visualizar");
    private JMenuItem nuevo = new JMenuItem("Nuevo");
    private JMenuItem salir = new JMenuItem("Salir");

    // Los dos paneles que podemos mostrar.
    private PanelVisualizar panelVisualizar = new PanelVisualizar();
    private PanelNuevo panelNuevo = new PanelNuevo();

    public VistaClientes() {

        // Crear la ventana.
        setTitle("Clientes");
        setSize(620, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Crear el menú.
        JMenu menu = new JMenu("Clientes");

        menu.add(visualizar);
        menu.add(nuevo);
        menu.add(salir);

        // Colocar el menú en la ventana.
        JMenuBar barra = new JMenuBar();
        barra.add(menu);
        setJMenuBar(barra);

        // Al empezar se muestra la lista de clientes.
        setContentPane(panelVisualizar);
    }

    public void mostrarVisualizar() {
        setContentPane(panelVisualizar);
        revalidate();
        repaint();
    }

    public void mostrarNuevo() {
        setContentPane(panelNuevo);
        revalidate();
        repaint();
    }

    public PanelVisualizar getPanelVisualizar() {
        return panelVisualizar;
    }

    public PanelNuevo getPanelNuevo() {
        return panelNuevo;
    }

    public void addVisualizarListener(ActionListener accion) {
        visualizar.addActionListener(accion);
    }

    public void addNuevoListener(ActionListener accion) {
        nuevo.addActionListener(accion);
    }

    public void addSalirListener(ActionListener accion) {
        salir.addActionListener(accion);
    }
}