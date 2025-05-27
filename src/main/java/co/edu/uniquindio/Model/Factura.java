package co.edu.uniquindio.Model;

import java.time.LocalDate;



import javax.swing.JOptionPane;

import co.edu.uniquindio.Interfaces.Detalles;

public class Factura implements Detalles{
    private Parqueadero parqueadero;
    private Vehiculo vehiculo;
    private double monto;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;

    public Factura(Parqueadero parqueadero, Vehiculo vehiculo, double monto, LocalDate fechaIngreso, LocalDate fechaSalida) {
        this.parqueadero = parqueadero;
        this.vehiculo = vehiculo;
        this.monto = monto;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void mostrarDetalles() {
        String mensaje = "========== FACTURA ==========\n" +
                "Parqueadero: " + parqueadero.getNombre() + "\n" +
                "Vehículo: " + vehiculo.getPlaca() + "\n" +
                "Tipo: " + vehiculo.getTipo() + "\n" +
                "Fecha ingreso: " + fechaIngreso + "\n" +
                "Fecha salida: " + fechaSalida + "\n" +
                "Monto a pagar: $" + monto + "\n" +
                "=============================";
        JOptionPane.showMessageDialog(null, mensaje, "Factura", JOptionPane.INFORMATION_MESSAGE);
    }
}

