package co.edu.uniquindio.Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;


import co.edu.uniquindio.Interfaces.CalculosGenerales;
import co.edu.uniquindio.Interfaces.Detalles;


public class Parqueadero implements CalculosGenerales, Detalles{

	 private String nombre;
	    private String direccion;
	    private String representante;
	    private String contacto;

	    private int espaciosMotos = 20;
	    private int espaciosAutos = 15;
	    private int espaciosCamiones = 5;

	    private double tarifaMoto = 2000;
	    private double tarifaAuto = 5000;
	    private double tarifaCamion = 10000;
	    private ArrayList<Vehiculo> vehiculos;
	    private ArrayList<Cliente> clientes;

	    // Constructor
	    public Parqueadero(String nombre, String direccion, String representante, String contacto) {
	        this.nombre = nombre;
	        this.direccion = direccion;
	        this.representante = representante;
	        this.contacto = contacto;
	    }

	    // Getters y Setters
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getDireccion() {
	        return direccion;
	    }

	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }

	    public String getRepresentante() {
	        return representante;
	    }

	    public void setRepresentante(String representante) {
	        this.representante = representante;
	    }

	    public String getContacto() {
	        return contacto;
	    }

	    public void setContacto(String contacto) {
	        this.contacto = contacto;
	    }

	    public int getEspaciosMotos() {
	        return espaciosMotos;
	    }

	    public void setEspaciosMotos(int espaciosMotos) {
	        this.espaciosMotos = espaciosMotos;
	    }

	    public int getEspaciosAutos() {
	        return espaciosAutos;
	    }

	    public void setEspaciosAutos(int espaciosAutos) {
	        this.espaciosAutos = espaciosAutos;
	    }

	    public int getEspaciosCamiones() {
	        return espaciosCamiones;
	    }

	    public void setEspaciosCamiones(int espaciosCamiones) {
	        this.espaciosCamiones = espaciosCamiones;
	    }

	    public double getTarifaMoto() {
	        return tarifaMoto;
	    }

	    public void setTarifaMoto(double tarifaMoto) {
	        this.tarifaMoto = tarifaMoto;
	    }

	    public double getTarifaAuto() {
	        return tarifaAuto;
	    }

	    public void setTarifaAuto(double tarifaAuto) {
	        this.tarifaAuto = tarifaAuto;
	    }

	    public double getTarifaCamion() {
	        return tarifaCamion;
	    }

	    public void setTarifaCamion(double tarifaCamion) {
	        this.tarifaCamion = tarifaCamion;
	    }
	   
	    public ArrayList<Vehiculo> getVehiculos() {
			return vehiculos;
		}

		public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
		}

		public ArrayList<Cliente> getClientes() {
			return clientes;
		}

		public void setClientes(ArrayList<Cliente> clientes) {
			this.clientes = clientes;
		}

		public void mostrarDetalles() {
	        String info = "Nombre: " + nombre +
	                      "\nDirección: " + direccion +
	                      "\nRepresentante: " + representante +
	                      "\nContacto: " + contacto +
	                      "\n\nEspacios disponibles:" +
	                      "\n- Motos: " + espaciosMotos +
	                      "\n- Automóviles: " + espaciosAutos +
	                      "\n- Camiones: " + espaciosCamiones +
	                      "\n\nTarifas (por hora):" +
	                      "\n- Moto: $" + tarifaMoto +
	                      "\n- Automóvil: $" + tarifaAuto +
	                      "\n- Camión: $" + tarifaCamion;

	        JOptionPane.showMessageDialog(null, info, "Información del Parqueadero", JOptionPane.INFORMATION_MESSAGE);
	    }
		public boolean agregarVehiculoACliente(ArrayList<Cliente> clientes, ArrayList<Vehiculo> vehiculos, String cedula, String placa) {
		    Vehiculo vehiculoEncontrado = null;
		    for (Vehiculo v : vehiculos) {
		        if (v.getPlaca().equalsIgnoreCase(placa)) {
		            vehiculoEncontrado = v;
		            break;
		        }
		    }

		    if (vehiculoEncontrado == null) {
		        JOptionPane.showMessageDialog(null, "Vehículo no encontrado en la lista general.");
		        return false;
		    }

		    for (Cliente cliente : clientes) {
		        if (cliente.getCedula().equalsIgnoreCase(cedula)) {
		            cliente.añadirVehiculoCompartido(vehiculoEncontrado);
		            JOptionPane.showMessageDialog(null, "Vehículo agregado al cliente: " + cliente.getNombre());
		            return true;
		        }
		    }

		    JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
		    return false;
		}
		public void agregarVehiculo(Vehiculo v) {
			vehiculos.add(v);
		}
		public void listarVehiculosDeCliente(ArrayList<Cliente> clientes, String cedulaCliente) {
		    for (Cliente cliente : clientes) {
		        if (cliente.getCedula().equalsIgnoreCase(cedulaCliente)) {
		            ArrayList<Vehiculo> vehiculos = cliente.getVehiculos();

		            if (vehiculos.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Este cliente no tiene vehículos registrados.",
		                                              "Vehículos del Cliente", JOptionPane.INFORMATION_MESSAGE);
		                return;
		            }

		            StringBuilder mensaje = new StringBuilder("Vehículos del cliente " + cliente.getNombre() + ":\n\n");
		            for (Vehiculo v : vehiculos) {
		                mensaje.append("Placa: ").append(v.getPlaca()).append("\n")
		                       .append("Tipo: ").append(v.getTipo()).append("\n")
		                       .append("Modelo: ").append(v.getModelo()).append("\n")
		                       .append("Color: ").append(v.getColor()).append("\n\n");
		            }

		            JOptionPane.showMessageDialog(null, mensaje.toString(), "Vehículos del Cliente", JOptionPane.INFORMATION_MESSAGE);
		            return;
		        }
		    }

		    JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
		}
	public Vehiculo buscarVehiculo(ArrayList<Vehiculo>vehiculosActuales,String placa) {
		for(Vehiculo vehiculo : vehiculosActuales) {
			if(vehiculo.getPlaca().equalsIgnoreCase(placa)){
				
				return vehiculo;
		}
		}
		JOptionPane.showMessageDialog(null,"Vehiculo no encontrado");
		return null;
	}
	@Override
	public double calcularPagoTotal(ArrayList<Vehiculo>vehiculosActuales) {
		double total = 0;
    	for(Vehiculo vehiculo : vehiculosActuales) {
    		Membresia membresia = vehiculo.getMembresia();
    		if(membresia !=null && membresia.estaActiva()) {
    			total+= membresia.getValor();
    		}
    	}
    	return total;
    }
	@Override
	public double calcularGananciasTotales(ArrayList<Double> montosTotales) {
	    double totalPagos = 0;



	    // Sumamos todos los pagos registrados
	    for (double monto : montosTotales) {
	        totalPagos += monto;
	    }

	    return totalPagos;
	}


}
