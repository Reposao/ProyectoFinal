package co.edu.uniquindio.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import co.edu.uniquindio.Model.Cliente;
import co.edu.uniquindio.Model.Parqueadero;
import co.edu.uniquindio.Model.Vehiculo;
import co.edu.uniquindio.Model.Moto;
import co.edu.uniquindio.Model.TipoVehiculo;
import co.edu.uniquindio.Model.Pago;
import co.edu.uniquindio.Model.Membresia;



public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculosActuales = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        LocalDateTime entrada = LocalDateTime.of(2025,5,20,10,0);
        LocalDateTime entrada2 = LocalDateTime.of(2025,5,23,10,0);


        // Crear parqueadero
        Parqueadero parqueadero = new Parqueadero("Parqueadero Cielo roto", "Calle 14", "Julian", "1092456757");
        cerebro cerebro = new cerebro(parqueadero);
        vehiculosActuales.add(new Moto("abc","Rojo","2020",TipoVehiculo.MOTO,200,entrada));
        parqueadero.setEspaciosMotos(parqueadero.getEspaciosMotos()-1);
        vehiculosActuales.add(new Moto("aaa","Azul","2025",TipoVehiculo.AUTOMOVIL,2000,entrada2));
        parqueadero.setEspaciosAutos(parqueadero.getEspaciosAutos()-1);
       

        // Crear cliente
        clientes.add(new Cliente("alejandro", "123"));
        Cliente cliente = new Cliente("alejandro", "123");

        // Mostrar menú con lista desplegable
        while (true) {
            String[] opciones = {
                "Registrar Vehículo",
                "Crear Cliente",
                "Agregar vehículo a cliente",
                "Ver clientes",
                "Ver Vehículos",
                "Ver vehículos cliente",
                "Eliminar vehículo",
                "Registrar Pago",
                "Ver Información del Parqueadero",
                "Comprar membresia",
                "Ver ganancias",
                "Modificar tarifas",
                "Ampliar espacios",
                "Salir"
            };

            String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione una opción:",
                "Menú Parqueadero",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );

            if (seleccion == null || seleccion.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema de parqueadero.");
                break;
            }

            switch (seleccion) {
                case "Registrar Vehículo":
                    cerebro.registrarVehiculo(vehiculosActuales);   
                    break;

                case "Crear Cliente":
                    cerebro.crearCliente(clientes);
                    break;

                case "Agregar vehículo a cliente":
                    String cedulaAgregar = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
                    String placaAgregar = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                    parqueadero.agregarVehiculoACliente(clientes, vehiculosActuales, cedulaAgregar, placaAgregar);
                    break;
                 
                case "Ver clientes" :
                	Cliente.mostrarClientes(clientes);
                	break;

                case "Ver Vehículos":
                    Vehiculo.mostrarDetalles(vehiculosActuales);
                    break;

                case "Ver vehículos cliente":
                    String cedulaVer = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
                    parqueadero.listarVehiculosDeCliente(clientes, cedulaVer);
                    break;

                case "Eliminar vehículo":
                    String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a eliminar:");
                    cliente.eliminarVehiculo(vehiculosActuales, placaEliminar);
                    break;

                case "Registrar Pago":
                	cerebro.registrarPago(vehiculosActuales);
                	break;
                   
                case "Comprar membresia":
           
                	cerebro.ComprarMembresia(vehiculosActuales);
                	break;
                
                case "Ver ganancias":
                	double ganancias = parqueadero.calcularPagoTotal(vehiculosActuales);
                	double v = cerebro.calcularGanancias();
                    JOptionPane.showMessageDialog(null, "Ganancias totales: $" + (ganancias+v));
                    break;
                    
                case "Modificar tarifas":
                	
                	String opcionTarifa =JOptionPane.showInputDialog("Tarifa a modificar (1: Moto, 2: Automovil, 3:Camion):");
                	if(opcionTarifa.equals("1")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nueva tarifa: "));
                		parqueadero.setTarifaMoto(cambio);
                		JOptionPane.showMessageDialog(null, "Tarifa cambiada.");
                	}else if(opcionTarifa.equals("2")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nueva tarifa: "));
                		parqueadero.setTarifaAuto(cambio);
                		JOptionPane.showMessageDialog(null, "Tarifa cambiada.");
                	}else if(opcionTarifa.equals("3")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nueva tarifa: "));
                		parqueadero.setTarifaCamion(cambio);
                		JOptionPane.showMessageDialog(null, "Tarifa cambiada.");
                	}
                	
                	break;
                
                case "Ampliar espacios" :
                	String opcionEspacio =JOptionPane.showInputDialog("Espacios a modificar (1: Moto, 2: Automovil, 3:Camion):");
                	if(opcionEspacio.equals("1")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nuevos espacios: "));
                		parqueadero.setEspaciosMotos(cambio);
                		JOptionPane.showMessageDialog(null, "Espacios cambiados.");
                	}else if(opcionEspacio.equals("2")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nuevos espacios: "));
                		parqueadero.setEspaciosAutos(cambio);
                		JOptionPane.showMessageDialog(null, "Espacios cambiados.");
                	}else if(opcionEspacio.equals("3")) {
                		int cambio = Integer.parseInt(JOptionPane.showInputDialog("Nuevos espacios: "));
                		parqueadero.setEspaciosCamiones(cambio);
                		JOptionPane.showMessageDialog(null, "Espacios cambiados.");
                	}
                	
                	break;

                case "Ver Información del Parqueadero":	
                    parqueadero.mostrarDetalles();
                    break;
            }
        }
    }

}
