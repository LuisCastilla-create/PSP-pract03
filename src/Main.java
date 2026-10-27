import controlador.ControladorClientes;
import controlador.ListaClientes;
import java.time.LocalDate;
import javax.swing.SwingUtilities;
import modelo.Cliente;
import vista.VistaClientes;

public class Main {
    public static void main(String[] args) {
        // La interfaz de Swing se crea en su hilo de eventos.
        SwingUtilities.invokeLater(() -> {
            ListaClientes lista = new ListaClientes();
            lista.anadirCliente(new Cliente(3, "Ana López", 150.5f, LocalDate.of(2000, 3, 15)));
            lista.anadirCliente(new Cliente(1, "Luis Pérez", 250f, LocalDate.of(2005, 8, 28)));
            lista.anadirCliente(new Cliente(2, "Marta Ruiz", 80f, LocalDate.of(1998, 11, 7)));
            lista.anadirCliente(new Cliente(4, "Samuel Rodriguez", 60f, LocalDate.of(2004, 07, 8)));
            lista.anadirCliente(new Cliente(5, "Jaime Garcia", 190f, LocalDate.of(2009, 12, 21)));

            VistaClientes vista = new VistaClientes();
            new ControladorClientes(lista, vista);
            vista.setVisible(true);
        });
    }
}
