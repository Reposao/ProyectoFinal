package co.edu.uniquindio.Interfaces;

import java.util.ArrayList;

import co.edu.uniquindio.Model.Vehiculo;


public interface CalculosGenerales {


	
	public double calcularPagoTotal(ArrayList<Vehiculo>vehiculosActuales);

	public double calcularGananciasTotales(ArrayList<Double> montosTotales);
}
