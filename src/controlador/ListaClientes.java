package controlador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import modelo.Cliente;

public class ListaClientes {

    private ArrayList<Cliente> clientes;
    private int actual;

    public ListaClientes() {
        clientes = new ArrayList<>();
        actual = 0;
    }

    public boolean esVacia() {
        return clientes.isEmpty();
    }

    public boolean esPrimero() {
        return !esVacia() && actual == 0;
    }

    public boolean esUltimo() {
        return !esVacia() && actual == clientes.size() - 1;
    }

    public void avanzar() {
        if (!esVacia() && !esUltimo()) {
            actual++;
        }
    }

    public void retroceder() {
        if (!esVacia() && !esPrimero()) {
            actual--;
        }
    }

    public void irAlPrimero() {
        actual = 0;
    }

    public void irAlUltimo() {
        if (!esVacia()) {
            actual = clientes.size() - 1;
        }
    }

    public void anadirCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void borrarCliente() {
        if (!esVacia()) {
            clientes.remove(actual);

            if (esVacia()) {
                actual = 0;
            } else if (actual >= clientes.size()) {
                actual = clientes.size() - 1;
            }
        }
    }

    public Cliente obtenerClienteActual() {
        if (esVacia()) {
            return null;
        }

        return clientes.get(actual);
    }

    public void ordenarPorNumero() {
        // sort utiliza el compareTo de Cliente.
        Collections.sort(clientes);
        irAlPrimero();
    }

    public int getActual() {
        return actual;
    }

    public int total() {
        return clientes.size();
    }
    
}