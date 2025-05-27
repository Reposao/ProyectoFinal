package co.edu.uniquindio.Model;

import java.time.LocalDate;
public class Membresia {
	
	  private TipoMembresia tipo;
	    private LocalDate fechaInicio;
	    private LocalDate fechaFin;
	    private double valor;


	    public Membresia(TipoMembresia tipo) {
	        this.tipo = tipo;
	        this.fechaInicio = LocalDate.now();
	        this.fechaFin = calcularFechaFin();
	        this.valor = tipo.getPrecio();
	    }
	    
	    public double getValor() {
	    	return valor;
	    }

	    // Calcula la fecha de vencimiento según el tipo de membresía
	    private LocalDate calcularFechaFin() {
	        switch (tipo) {
	            case MENSUAL:
	                return fechaInicio.plusMonths(1);
	            case TRIMESTRAL:
	                return fechaInicio.plusMonths(3);
	            case ANUAL:
	                return fechaInicio.plusYears(1);
	            default:
	                return fechaInicio;
	        }
	    }

	    public boolean estaActiva() {
	    	return !LocalDate.now().isAfter(fechaFin);
	    }
	    
	    public TipoMembresia getTipo() {
	        return tipo;
	    }

	    public LocalDate getFechaInicio() {
	        return fechaInicio;
	    }

	    public LocalDate getFechaFin() {
	        return fechaFin;
	    }
	}
