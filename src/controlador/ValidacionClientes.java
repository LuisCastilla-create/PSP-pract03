package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Cliente;

public class ValidacionClientes {

    // Se utiliza para mostrar las fechas en la ventana.
    public static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static Cliente crearCliente(String textoNumero, String nombre,
            String textoPuntos, String textoFecha) {

        int numero;
        float puntos;
        LocalDate fecha;

        // Comprobar el número de cliente.
        try {
            numero = Integer.parseInt(textoNumero);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "El número de cliente debe ser un entero.");
        }

        // Comprobar que se haya escrito un nombre.
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Debes escribir un nombre.");
        }

        // Convertir los puntos a un número decimal.
        try {
            puntos = Float.parseFloat(textoPuntos);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Los puntos deben ser un número.");
        }

        // Comprobar el rango de puntos.
        if (puntos >= 0 && puntos <= 1000) {
            // Los puntos son correctos.
        } else {
            throw new IllegalArgumentException(
                    "Los puntos deben estar entre 0 y 1000.");
        }

        // Separar la fecha en día, mes y año.
        String[] partes = textoFecha.split("/");

        if (partes.length != 3) {
            throw new IllegalArgumentException(
                    "Escribe la fecha como día/mes/año.");
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);

            fecha = LocalDate.of(anio, mes, dia);

        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "La fecha introducida no es válida.");
        }

        // Comprobar el año de nacimiento.
        if (fecha.getYear() < 1900 || fecha.getYear() > 2015) {
            throw new IllegalArgumentException(
                    "El año debe estar entre 1900 y 2015.");
        }

        return new Cliente(numero, nombre, puntos, fecha);
    }
}
