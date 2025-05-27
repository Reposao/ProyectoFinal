package co.edu.uniquindio.Modells;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import co.edu.uniquindio.Interfaces.Detalles;


public class Moto extends Vehiculo implements Detalles {
	
	private int cilindraje;
	
	public Moto (String placa , String color , String modelo , TipoVehiculo tipo , int cilindraje,LocalDateTime horaEntrada) {
		
		super ( placa , color , modelo , tipo, horaEntrada);
		this.cilindraje = cilindraje;
		
	}

	public int getCilindraje() {
		return cilindraje;
	}

	 @Override
	    public void mostrarDetalles() {
	        String mensaje = "Tipo: Moto\n" +
	                         "Placa: " + getPlaca() + "\n" +
	                         "Color: " + getColor() + "\n" +
	                         "Modelo: " + getModelo() + "\n" +
	                         "Cilindraje: " + cilindraje + " cc";
	        JOptionPane.showMessageDialog(null, mensaje, "Detalles de la Moto", JOptionPane.INFORMATION_MESSAGE);
	 }

     public void setCilindraje(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCilindraje'");
     }
}
