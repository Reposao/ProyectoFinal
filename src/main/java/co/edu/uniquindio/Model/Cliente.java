package co.edu.uniquindio.Modells;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private ArrayList<Vehiculo> vehiculosActuales;
    private ArrayList<Cliente>clientes;

    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.vehiculosActuales = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    // Getters seguros (listas inmutables)
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculosActuales;
    }
    
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	// Métodos para modificar datos de forma controlada
    public void actualizarInformacion(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Añadir vehículo (solo si no existe ya)
    public void añadirVehiculoCompartido(Vehiculo vehiculo) {
        if (!vehiculosActuales.contains(vehiculo)) {
            vehiculosActuales.add(vehiculo);
            vehiculo.añadirCliente(this);  // Asegura bidireccionalidad
            JOptionPane.showMessageDialog(null, "Vehículo añadido exitosamente.");
            System.out.println("Vehículo añadido: -Placa " + vehiculo.getPlaca() + " al cliente: "+ getNombre());  // Depuración
        } else {
            JOptionPane.showMessageDialog(null, "Este vehículo ya está registrado.");
        }
    }

    // Eliminar vehículo
    public boolean eliminarVehiculo(ArrayList<Vehiculo>vehiculosActuales,String placa) {
        Vehiculo vehiculoEncontrado = null;

        for (Vehiculo v : vehiculosActuales) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoEncontrado = v;
                break;
            }
        }

        if (vehiculoEncontrado != null) {
            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Desea eliminar el siguiente vehículo?\n\n"
                  + "Placa: " + vehiculoEncontrado.getPlaca() + "\n"
                  + "Tipo: " + vehiculoEncontrado.getTipo() + "\n"
                  + "Modelo: " + vehiculoEncontrado.getModelo() + "\n"
                  + "Color: " + vehiculoEncontrado.getColor(),
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                vehiculosActuales.remove(vehiculoEncontrado);
                JOptionPane.showMessageDialog(null, "Vehículo eliminado exitosamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Eliminación cancelada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }

        return false;
    }

    // Buscar vehículo por placa
    public Vehiculo buscarVehiculo(ArrayList<Vehiculo>vehiculosActuales,String placa) {
        for (Vehiculo v : vehiculosActuales) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    // Mostrar vehículos en JOptionPane
    public void mostrarDetalles() {
        if (vehiculosActuales.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Este cliente no tiene vehículos registrados.",
                                          "Vehículos del Cliente", JOptionPane.INFORMATION_MESSAGE);
        } else {
            StringBuilder mensaje = new StringBuilder("Vehículos del cliente:\n");
            for (Vehiculo v : vehiculosActuales) {
                mensaje.append("Placa: ").append(v.getPlaca()).append("\n")
                       .append("Tipo: ").append(v.getTipo()).append("\n")
                       .append("Modelo: ").append(v.getModelo()).append("\n")
                       .append("Color: ").append(v.getColor()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString(),
                                          "Vehículos del Cliente", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    

    public static void mostrarClientes(ArrayList<Cliente>clientes) {
    	if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay clientes actualmente.");
            return;
        }


        StringBuilder mensaje = new StringBuilder("Clientes actuales:\n");
        for (Cliente cliente : clientes) {
            mensaje.append("- Nombre: ").append(cliente.getNombre())
                   .append(" | Cedula: ").append(cliente.getCedula()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

    public void setNombre(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    public void setIdentificacion(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdentificacion'");
    }

    public Object getIdentificacion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdentificacion'");
    }
    
}

