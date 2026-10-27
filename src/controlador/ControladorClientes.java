package controlador;

import modelo.Cliente;
import vista.PanelNuevo;
import vista.PanelVisualizar;
import vista.VistaClientes;

public class ControladorClientes {
    private ListaClientes lista;
    private VistaClientes vista;

    public ControladorClientes(ListaClientes lista, VistaClientes vista) {
        this.lista = lista;
        this.vista = vista;
        PanelVisualizar panel = vista.getPanelVisualizar();

        // Cada botón cambia la posición y después actualiza los datos.
        panel.addPrimeroListener(e -> { lista.irAlPrimero(); mostrar(); });
        panel.addAnteriorListener(e -> { lista.retroceder(); mostrar(); });
        panel.addSiguienteListener(e -> { lista.avanzar(); mostrar(); });
        panel.addUltimoListener(e -> { lista.irAlUltimo(); mostrar(); });
        panel.addBorrarListener(e -> { lista.borrarCliente(); mostrar(); });
        panel.addOrdenarListener(e -> { lista.ordenarPorNumero(); mostrar(); });

        vista.addVisualizarListener(e -> {
            mostrar();
            vista.mostrarVisualizar();
        });
        vista.addNuevoListener(e -> {
            vista.getPanelNuevo().limpiar();
            vista.mostrarNuevo();
        });
        vista.addSalirListener(e -> vista.dispose());
        vista.getPanelNuevo().addGuardarListener(e -> guardarCliente());
        mostrar();
    }

    public void mostrar() {
        PanelVisualizar panel = vista.getPanelVisualizar();
        Cliente cliente = lista.obtenerClienteActual();
        if (cliente == null) {
            panel.mostrarCliente("", "", "", "", 0, 0);
            panel.setBotones(false, false, false);
        } else {
            panel.mostrarCliente(String.valueOf(cliente.getNumero()),
                    cliente.getNombre(), String.valueOf(cliente.getPuntos()),
                    cliente.getFechaNacimiento().format(ValidacionClientes.FORMATO),
                    lista.getActual() + 1, lista.total());
            panel.setBotones(!lista.esPrimero(), !lista.esUltimo(), true);
        }
    }

    private void guardarCliente() {
        PanelNuevo panel = vista.getPanelNuevo();
        try {
            Cliente cliente = ValidacionClientes.crearCliente(panel.getNumero(),
                    panel.getNombre(), panel.getPuntos(), panel.getFecha());
            lista.anadirCliente(cliente);
            lista.irAlUltimo();
            mostrar();
            panel.limpiar();
            vista.mostrarVisualizar();
        } catch (IllegalArgumentException e) {
            // No se guarda nada si algún dato es incorrecto.
            panel.mostrarError(e.getMessage());
        }
    }
}
