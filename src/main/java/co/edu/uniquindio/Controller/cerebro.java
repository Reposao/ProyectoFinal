package co.edu.uniquindio.Controller;

import co.edu.uniquindio.Model.Parqueadero;

import co.edu.uniquindio.Model.Cliente;

import co.edu.uniquindio.Model.Camion;

import co.edu.uniquindio.Model.Moto;

import co.edu.uniquindio.Model.Pago;

import co.edu.uniquindio.Model.Vehiculo;

import co.edu.uniquindio.Model.TipoMembresia;

import co.edu.uniquindio.Model.TipoVehiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.Model.Automovil;






public class cerebro {
	private Parqueadero parqueadero;
	ArrayList<Vehiculo> vehiculosActuales = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Double>montosTotales = new ArrayList<>();
    
    public cerebro(Parqueadero parqueadero) {
    	this.parqueadero = parqueadero;
    }
    
    public void registrarVehiculo(ArrayList<Vehiculo> vehiculosActuales) {

		String tipoVehiculo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo (1: Moto, 2: Automóvil, 3: Camión):");
        String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
        String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
        LocalDateTime horaEntrada = LocalDateTime.now();

        
        if (tipoVehiculo.equals("1")) {
        	if(parqueadero.getEspaciosMotos()>0) {
        		int cilindraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el cilindraje de la moto:"));
        		vehiculosActuales.add(new Moto(placa, color, modelo, TipoVehiculo.MOTO, cilindraje,horaEntrada));
        		parqueadero.setEspaciosMotos(parqueadero.getEspaciosMotos()-1);
        	}else {
        		JOptionPane.showMessageDialog(null, "No hay mas espacios para motos." );
        	}
        } else if (tipoVehiculo.equals("2")) {
        	if(parqueadero.getEspaciosAutos()>0) {
        		int numeroPuertas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese le numero de puertas; "));
        		vehiculosActuales.add(new Automovil(placa, color, modelo, TipoVehiculo.AUTOMOVIL, numeroPuertas,horaEntrada));
        		parqueadero.setEspaciosAutos(parqueadero.getEspaciosAutos()-1);
        	}else {
        		JOptionPane.showMessageDialog(null, "No hay mas espacios para autos." );
        	}
        } else if (tipoVehiculo.equals("3")) {
        	if(parqueadero.getEspaciosCamiones()>0) {
        		double capacidadCarga = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la capacidad de carga del camión (en toneladas):"));
        		vehiculosActuales.add(new Camion(placa, color, modelo, TipoVehiculo.CAMION, capacidadCarga,horaEntrada));
        		parqueadero.setEspaciosCamiones(parqueadero.getEspaciosCamiones()-1);
        	}
        	}else {
        	JOptionPane.showMessageDialog(null, "No hay espacios para mas camiones." );
        }
        
        JOptionPane.showMessageDialog(null, "Vehículo registrado exitosamente." );
}

	public void crearCliente(ArrayList<Cliente>clientes) {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
    	String cedula = JOptionPane.showInputDialog("Ingrese la cédula:");
    	String telefono = JOptionPane.showInputDialog("Ingrese un telefono:");
    	String correo = JOptionPane.showInputDialog("Ingrese un correo electronico:");
    	JOptionPane.showMessageDialog(null, "Cliente creado correctamente");
    	clientes.add(new Cliente(nombre,cedula));
	}
	public void registrarPago(ArrayList<Vehiculo> vehiculosActuales) {
		Cliente cliente = new Cliente("alejandro", "1234567890");

        
		String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo para registrar el pago:");

		Vehiculo vehiculoPago = cliente.buscarVehiculo(vehiculosActuales, placa);
        
        if (vehiculoPago != null) {
            double tarifaBase = 0;
     
			// Calcular tarifa según tipo de vehículo
            if (vehiculoPago instanceof Moto) {
                tarifaBase = parqueadero.getTarifaMoto();
            } else if (vehiculoPago instanceof Automovil) {
                tarifaBase = parqueadero.getTarifaAuto();
            } else if (vehiculoPago instanceof Camion) {
                tarifaBase = parqueadero.getTarifaCamion();
            }
            
            
            LocalDateTime entrada = LocalDateTime.now();

            
            LocalDateTime salida = LocalDateTime.now();




            Pago pago = new Pago(vehiculoPago,entrada,tarifaBase);
            double monto = pago.registrarPago(salida,"efectivo");
            montosTotales.add(monto);
            vehiculosActuales.remove(vehiculoPago);
            // Generar factura
            pago.generarFactura(salida);
	
        } else {
        	JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
     }
	}
	public double calcularGanancias() {
		
		double total = parqueadero.calcularGananciasTotales(montosTotales);
    	return total;
	}
	public void ComprarMembresia(ArrayList<Vehiculo>vehiculosActuales) {
		String placa = JOptionPane.showInputDialog("Ingrese la placa del vehiculo a comprar membresia");
    	Vehiculo vehiculo = parqueadero.buscarVehiculo(vehiculosActuales, placa);
    	if(vehiculo !=null) {
    	if (vehiculo.getMembresia() != null && vehiculo.getMembresia().estaActiva()) {
            JOptionPane.showMessageDialog(null, "El cliente ya tiene una membresía activa hasta: " +
                    vehiculo.getMembresia().getFechaFin());
          return;
	}	
    	
    	
    	String[] opciones1 = {"MENSUAL - $50.000", "TRIMESTRAL - $120.000", "ANUAL - $500.000"};
        int eleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione el tipo de membresía",
            "Compra de membresía",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.INFORMATION_MESSAGE,
            null,
            opciones1,
            opciones1[0]
            		
        );

        TipoMembresia tipoSeleccionado = switch (eleccion) {
            case 0 -> TipoMembresia.MENSUAL;
            case 1 -> TipoMembresia.TRIMESTRAL;
            case 2 -> TipoMembresia.ANUAL;
            default -> null;
        };

        if (tipoSeleccionado != null) {
            vehiculo.comprarMembresia(tipoSeleccionado);
            JOptionPane.showMessageDialog(null, "Membresia comprada exitosamente");
        } else {
            JOptionPane.showMessageDialog(null, "Compra cancelada.");
        }
    	
    	}
	}
 
}
