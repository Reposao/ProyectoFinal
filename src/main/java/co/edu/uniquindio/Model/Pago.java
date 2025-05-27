package co.edu.uniquindio.Modells;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.Interfaces.Facturacion;

public class Pago implements Facturacion{
	private Vehiculo vehiculo;
	private double monto;
	private LocalDateTime horaIngreso;
	private LocalDateTime horaSalida;
	private double tarifaHora;
	private long horasTotales;
	private String metodoPago;
	private boolean pagado;
	private ArrayList<Double>montosTotales = new ArrayList<>();

	public Pago(Vehiculo vehiculo, LocalDateTime horaIngreso, double tarifaHora) {
		
		this.vehiculo = vehiculo;
		this.horaIngreso = horaIngreso;
		this.tarifaHora = tarifaHora;
		this.pagado = false;
	}

	public Pago(Vehiculo moto, LocalDateTime now) {
        //TODO Auto-generated constructor stub
    }

    public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public LocalDateTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalDateTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalDateTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalDateTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getTarifaHora() {
		return tarifaHora;
	}
	public void setTarifaHora(double tarifaHora) {
		this.tarifaHora = tarifaHora;
	}
	public long getHoras() {
		return horasTotales;
	}

	public void setHoras(long horasTotales) {
		this.horasTotales = horasTotales;
	}

    // Método para registrar el pago (simulado con mensaje)
	public double registrarPago(LocalDateTime horaSalida, String metodoPago) {
		
	    Duration duracion = Duration.between(vehiculo.getHoraEntrada(), horaSalida);
	    long minutos = duracion.toMinutes();
	    this.horasTotales = (minutos + 59) / 60;
	    this.monto = horasTotales * tarifaHora;
	    this.pagado = true;
	    this.metodoPago = metodoPago;

	    String mensaje = "Pago registrado para el vehículo: " + vehiculo.getPlaca() + "\n"
	                   + "Horas: " + horasTotales + "\n"
	                   + "Monto: $" + monto + "\n"
	                   + "Método de pago: " + metodoPago;

	    JOptionPane.showMessageDialog(null, mensaje, "Pago Registrado", JOptionPane.INFORMATION_MESSAGE);
	    return monto;
	}

    // Método para generar y mostrar factura asociada
	public void generarFactura(LocalDateTime horaSalida) {
	    if (!pagado) {
	        JOptionPane.showMessageDialog(null, "⚠️ Aún no se ha registrado el pago.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    String factura = "========== FACTURA ==========\n"
	                   + "Vehículo:        " + vehiculo.getPlaca() + "\n"
	                   + "Hora de entrada: " + vehiculo.getHoraEntrada().format(formatter) + "\n"
	                   + "Hora de salida:  " + horaSalida.format(formatter) + "\n"
	                   + "Horas totales:   " + horasTotales + "\n"
	                   + "Monto total:     $" + monto + "\n"
	                   + "Método de pago:  " + metodoPago + "\n"
	                   + "Estado:          PAGADO ✅\n"
	                   + "=============================";

	    JOptionPane.showMessageDialog(null, factura, "Factura", JOptionPane.INFORMATION_MESSAGE);
	}

	public double pagosTotales() {
		double suma = 0;
		for(double pago : montosTotales) {
			suma += pago;
			
		}
		return suma;
	}

    public int getValor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValor'");
    }

}

