package co.edu.uniquindio.Model;

public enum  TipoMembresia {
	
	MENSUAL(50000),
    TRIMESTRAL(120000),
    ANUAL(500000);

    private final int precio;

    TipoMembresia(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
        
    }
}