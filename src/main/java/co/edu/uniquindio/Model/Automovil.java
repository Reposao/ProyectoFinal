package co.edu.uniquindio.Modells;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import co.edu.uniquindio.Interfaces.Detalles;

public class Automovil extends Vehiculo implements Detalles {
	private int numeroPuertas;
	
	
	public Automovil (String placa , String color , String modelo , TipoVehiculo tipo , int numeroPuertas,LocalDateTime horaEntrada) {
		super(placa , color , modelo , tipo, horaEntrada);
		this.numeroPuertas = numeroPuertas;
		
	}
	
    public int getnumeroPuertas() {
		return numeroPuertas;
	}


	public void setnumeroPuertas(int numeroPuertas) {
		this.numeroPuertas = numeroPuertas;
	}


	public void mostrarDetalles() {
        String mensaje = "Tipo: Automóvil\n" +
                         "Placa: " + getPlaca() + "\n" +
                         "Color: " + getColor() + "\n" +
                         "Modelo: " + getModelo() + "\n" +
                         "Número de Puertas: " + numeroPuertas;
        JOptionPane.showMessageDialog(null, mensaje, "Detalles del Automóvil", JOptionPane.INFORMATION_MESSAGE);
    }
}
	
   


