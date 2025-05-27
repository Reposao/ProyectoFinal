package co.edu.uniquindio.Model;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.Interfaces.Detalles;
import co.edu.uniquindio.Interfaces.MembresiaCompra;


public abstract class Vehiculo implements Detalles,MembresiaCompra {

    private String placa;
    private String color;
    private String modelo;
    private TipoVehiculo tipo;
    private LocalDateTime horaEntrada;
    private Membresia membresia;
    private Pago pago;
    private ArrayList<Cliente> clientes; // NUEVO: lista de clientes asociados
    private ArrayList<Vehiculo> vehiculosActuales;
    
    public Vehiculo(String placa, String color, String modelo, TipoVehiculo tipo, LocalDateTime horaEntrada) {
        this.placa = placa;
        this.color = color;
        this.modelo = modelo;
        this.tipo = tipo;
        this.clientes = new ArrayList<>(); // Inicializar lista
        this.horaEntrada = horaEntrada;
    }

    // Getters y Setters
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Vehiculo> getVehiculosActuales(){
    	return vehiculosActuales;
    }
    public Pago getPago() {
    	return pago;
    }
    
   
    public LocalDateTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalDateTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	// NUEVO: Añadir cliente al vehículo
    public void añadirCliente(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public void actualizarInformacionVehiculo(String color, String modelo) {
        this.color = color;
        this.modelo = modelo;
    }


 
    public static void mostrarDetalles(ArrayList<Vehiculo>vehiculosActuales) {
    	if (vehiculosActuales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay vehiculos actualmente.");
            return;
        }

        StringBuilder mensaje = new StringBuilder("Vehiculos actuales:\n");
        for (Vehiculo vehiculo : vehiculosActuales) {
            mensaje.append("- Placa: ").append(vehiculo.getPlaca())
                   .append(" | Tipo: ").append(vehiculo.getTipo())
                   .append(" | Color: ").append(vehiculo.getColor()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }
    public void comprarMembresia(TipoMembresia tipo) {
        this.membresia = new Membresia(tipo);
        JOptionPane.showMessageDialog(null, "Membresía " + tipo + " comprada por $" + tipo.getPrecio() + 
        		"\nFecha de inicio: "+membresia.getFechaInicio()+
                "\nVálida hasta: " + membresia.getFechaFin());
    	
}
    
}
