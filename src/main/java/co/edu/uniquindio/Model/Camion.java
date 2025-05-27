package co.edu.uniquindio.Model;
	
import java.time.LocalDateTime;

import javax.swing.JOptionPane;



public class Camion extends Vehiculo implements Detalles{
	
	private double capacidadCarga;
	
	public Camion (String placa , String color , String modelo , TipoVehiculo tipo , double capacidadCarga,LocalDateTime horaEntrada) {
		
		super ( placa , color , modelo , tipo, horaEntrada );
		
		this.capacidadCarga = capacidadCarga;
		
	}

	public double getCapacidadCarga() {
		return capacidadCarga;
	}
	  @Override
	    public void mostrarDetalles() {
	        String mensaje = "Tipo: Camión\n" +
	                         "Placa: " + getPlaca() + "\n" +
	                         "Color: " + getColor() + "\n" +
	                         "Modelo: " + getModelo() + "\n" +
	                         "Capacidad de carga: " + capacidadCarga + " toneladas";
	        JOptionPane.showMessageDialog(null, mensaje, "Detalles del Camión", JOptionPane.INFORMATION_MESSAGE);

}
  }
