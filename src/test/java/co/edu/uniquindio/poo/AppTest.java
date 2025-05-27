package co.edu.uniquindio.poo;

/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import co.edu.uniquindio.Model.*;

public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    @Test
    public void testCrearMotoConDatosValidos() {
        LOG.info("Iniciado testCrearMotoConDatosValidos");
        Moto moto = new Moto("ABC123", "Rojo", "2020", TipoVehiculo.MOTO, 150, LocalDateTime.now());
        assertEquals("ABC123", moto.getPlaca());
        assertEquals("Rojo", moto.getColor());
        assertEquals("2020", moto.getModelo());
        assertEquals(TipoVehiculo.MOTO, moto.getTipo());
        assertEquals(150, moto.getCilindraje());
        LOG.info("Finalizado testCrearMotoConDatosValidos");
    }

    @Test
    public void testActualizarInformacionVehiculo() {
        LOG.info("Iniciado testActualizarInformacionVehiculo");
        Moto moto = new Moto("XYZ789", "Azul", "2019", TipoVehiculo.MOTO, 200, LocalDateTime.now());
        moto.actualizarInformacionVehiculo("Negro", "2021");
        assertEquals("Negro", moto.getColor());
        assertEquals("2021", moto.getModelo());
        LOG.info("Finalizado testActualizarInformacionVehiculo");
    }

    @Test
    public void testAñadirCliente() {
        LOG.info("Iniciado testAñadirCliente");
        Moto moto = new Moto("DEF456", "Gris", "2022", TipoVehiculo.MOTO, 100, LocalDateTime.now());
        Cliente cliente = new Cliente("Juan", "123");
        moto.añadirCliente(cliente);
        assertTrue(moto.getClientes().contains(cliente));
        LOG.info("Finalizado testAñadirCliente");
    }

    @Test
    public void testAñadirClienteDuplicado() {
        LOG.info("Iniciado testAñadirClienteDuplicado");
        Moto moto = new Moto("DEF457", "Verde", "2023", TipoVehiculo.MOTO, 125, LocalDateTime.now());
        Cliente cliente = new Cliente("Ana", "456");
        moto.añadirCliente(cliente);
        moto.añadirCliente(cliente);
        assertEquals(1, moto.getClientes().size());
        LOG.info("Finalizado testAñadirClienteDuplicado");
    }

    @Test
    public void testComprarMembresiaMensual() {
        LOG.info("Iniciado testComprarMembresiaMensual");
        Moto moto = new Moto("AAA111", "Amarillo", "2020", TipoVehiculo.MOTO, 160, LocalDateTime.now());
        moto.comprarMembresia(TipoMembresia.MENSUAL);
        assertEquals(TipoMembresia.MENSUAL, moto.getMembresia().getTipo());
        LOG.info("Finalizado testComprarMembresiaMensual");
    }

    @Test
    public void testComprarMembresiaTrimestral() {
        LOG.info("Iniciado testComprarMembresiaTrimestral");
        Moto moto = new Moto("BBB222", "Blanco", "2021", TipoVehiculo.MOTO, 180, LocalDateTime.now());
        moto.comprarMembresia(TipoMembresia.TRIMESTRAL);
        assertEquals(TipoMembresia.TRIMESTRAL, moto.getMembresia().getTipo());
        LOG.info("Finalizado testComprarMembresiaTrimestral");
    }

    @Test
    public void testTipoVehiculoEnum() {
        LOG.info("Iniciado testTipoVehiculoEnum");
        assertEquals("MOTO", TipoVehiculo.MOTO.name());
        assertEquals("CAMION", TipoVehiculo.CAMION.name());
        LOG.info("Finalizado testTipoVehiculoEnum");
    }

    @Test
    public void testPrecioMembresiaMensual() {
        LOG.info("Iniciado testPrecioMembresiaMensual");
        assertEquals(50000, TipoMembresia.MENSUAL.getPrecio());
        LOG.info("Finalizado testPrecioMembresiaMensual");
    }

    @Test
    public void testPrecioMembresiaTrimestral() {
        LOG.info("Iniciado testPrecioMembresiaTrimestral");
        assertEquals(120000, TipoMembresia.TRIMESTRAL.getPrecio());
        LOG.info("Finalizado testPrecioMembresiaTrimestral");
    }

    @Test
    public void testPrecioMembresiaAnual() {
        LOG.info("Iniciado testPrecioMembresiaAnual");
        assertEquals(500000, TipoMembresia.ANUAL.getPrecio());
        LOG.info("Finalizado testPrecioMembresiaAnual");
    }

    @Test
    public void testSetPlaca() {
        LOG.info("Iniciado testSetPlaca");
        Moto moto = new Moto("PPP333", "Café", "2018", TipoVehiculo.MOTO, 140, LocalDateTime.now());
        moto.setPlaca("QQQ444");
        assertEquals("QQQ444", moto.getPlaca());
        LOG.info("Finalizado testSetPlaca");
    }

    @Test
    public void testSetColor() {
        LOG.info("Iniciado testSetColor");
        Moto moto = new Moto("RRR555", "Lila", "2017", TipoVehiculo.MOTO, 110, LocalDateTime.now());
        moto.setColor("Rosa");
        assertEquals("Rosa", moto.getColor());
        LOG.info("Finalizado testSetColor");
    }

    @Test
    public void testSetModelo() {
        LOG.info("Iniciado testSetModelo");
        Moto moto = new Moto("SSS666", "Negro", "2016", TipoVehiculo.MOTO, 125, LocalDateTime.now());
        moto.setModelo("2019");
        assertEquals("2019", moto.getModelo());
        LOG.info("Finalizado testSetModelo");
    }

    @Test
    public void testHoraEntrada() {
        LOG.info("Iniciado testHoraEntrada");
        LocalDateTime entrada = LocalDateTime.of(2025, 5, 25, 10, 0);
        Moto moto = new Moto("TTT777", "Blanco", "2020", TipoVehiculo.MOTO, 170, entrada);
        assertEquals(entrada, moto.getHoraEntrada());
        LOG.info("Finalizado testHoraEntrada");
    }

    @Test
    public void testCambiarHoraEntrada() {
        LOG.info("Iniciado testCambiarHoraEntrada");
        Moto moto = new Moto("UUU888", "Azul", "2022", TipoVehiculo.MOTO, 190, LocalDateTime.now());
        LocalDateTime nueva = LocalDateTime.of(2025, 6, 1, 8, 30);
        moto.setHoraEntrada(nueva);
        assertEquals(nueva, moto.getHoraEntrada());
        LOG.info("Finalizado testCambiarHoraEntrada");
    }

    @Test
    public void testClientesInicialesVacios() {
        LOG.info("Iniciado testClientesInicialesVacios");
        Moto moto = new Moto("VVV999", "Gris", "2023", TipoVehiculo.MOTO, 200, LocalDateTime.now());
        assertTrue(moto.getClientes().isEmpty());
        LOG.info("Finalizado testClientesInicialesVacios");
    }

    @Test
    public void testTipoVehiculoSetterYGetter() {
        LOG.info("Iniciado testTipoVehiculoSetterYGetter");
        Moto moto = new Moto("WWW111", "Rojo", "2024", TipoVehiculo.MOTO, 110, LocalDateTime.now());
        moto.setTipo(TipoVehiculo.AUTOMOVIL);
        assertEquals(TipoVehiculo.AUTOMOVIL, moto.getTipo());
        LOG.info("Finalizado testTipoVehiculoSetterYGetter");
    }

    @Test
    public void testAgregarMultiplesClientes() {
        LOG.info("Iniciado testAgregarMultiplesClientes");
        Moto moto = new Moto("XYZ321", "Negro", "2021", TipoVehiculo.MOTO, 125, LocalDateTime.now());
        Cliente c1 = new Cliente("Carlos", "111");
        Cliente c2 = new Cliente("Luisa", "222");
        moto.añadirCliente(c1);
        moto.añadirCliente(c2);
        assertEquals(2, moto.getClientes().size());
        LOG.info("Finalizado testAgregarMultiplesClientes");
    }

    @Test
    public void testSetYGetTipoMembresia() {
        LOG.info("Iniciado testSetYGetTipoMembresia");
        Moto moto = new Moto("HHH555", "Verde", "2019", TipoVehiculo.MOTO, 150, LocalDateTime.now());
        Membresia membresia = new Membresia(TipoMembresia.TRIMESTRAL);
        moto.setMembresia(membresia);
        assertEquals(TipoMembresia.TRIMESTRAL, moto.getMembresia().getTipo());
        LOG.info("Finalizado testSetYGetTipoMembresia");
    }

    @Test
    public void testToStringTipoVehiculo() {
        LOG.info("Iniciado testToStringTipoVehiculo");
        assertEquals("AUTOMOVIL", TipoVehiculo.AUTOMOVIL.toString());
        LOG.info("Finalizado testToStringTipoVehiculo");
    }

    @Test
    public void testToStringTipoMembresia() {
        LOG.info("Iniciado testToStringTipoMembresia");
        assertEquals("ANUAL", TipoMembresia.ANUAL.toString());
        LOG.info("Finalizado testToStringTipoMembresia");
    }















    @Test
public void testRegistrarClienteEnVehiculo() {
    LOG.info("Iniciado testRegistrarClienteEnVehiculo");
    Vehiculo moto = new Moto("ABC123", "Rojo", "2022", TipoVehiculo.MOTO, 125, LocalDateTime.now());
    Cliente cliente = new Cliente("Alejandro", "123456");
    
    moto.añadirCliente(cliente);

    assertTrue(moto.getClientes().contains(cliente));
    assertEquals(1, moto.getClientes().size());
    LOG.info("Finalizado testRegistrarClienteEnVehiculo");
}

@Test
public void testNoDuplicarClienteEnVehiculo() {
    LOG.info("Iniciado testNoDuplicarClienteEnVehiculo");
    Vehiculo moto = new Moto("XYZ789", "Negro", "2023", TipoVehiculo.MOTO, 150, LocalDateTime.now());
    Cliente cliente = new Cliente("Diana", "654321");

    moto.añadirCliente(cliente);
    moto.añadirCliente(cliente); // debe evitar duplicado

    assertEquals(1, moto.getClientes().size());
    LOG.info("Finalizado testNoDuplicarClienteEnVehiculo");
}

@Test
public void testActualizarInformacionVehiculo() {
    LOG.info("Iniciado testActualizarInformacionVehiculo");
    Vehiculo moto = new Moto("JKL999", "Gris", "2018", TipoVehiculo.MOTO, 180, LocalDateTime.now());

    moto.actualizarInformacionVehiculo("Negro", "2023");

    assertEquals("Negro", moto.getColor());
    assertEquals("2023", moto.getModelo());
    LOG.info("Finalizado testActualizarInformacionVehiculo");
}

@Test
public void testComprarMembresiaYAsignar() {
    LOG.info("Iniciado testComprarMembresiaYAsignar");
    Vehiculo moto = new Moto("DEF456", "Amarillo", "2019", TipoVehiculo.MOTO, 100, LocalDateTime.now());

    moto.comprarMembresia(TipoMembresia.TRIMESTRAL);
    assertNotNull(moto.getMembresia());
    assertEquals(TipoMembresia.TRIMESTRAL, moto.getMembresia().getTipo());
    LOG.info("Finalizado testComprarMembresiaYAsignar");
}

@Test
public void testCrearClienteCorrecto() {
    LOG.info("Iniciado testCrearClienteCorrecto");
    Cliente cliente = new Cliente("Laura", "998877");

    assertEquals("Laura", cliente.getNombre());
    assertEquals("998877", cliente.getIdentificacion());
    LOG.info("Finalizado testCrearClienteCorrecto");
}

@Test
public void testCompararClientes() {
    LOG.info("Iniciado testCompararClientes");
    Cliente cliente1 = new Cliente("Ana", "111222");
    Cliente cliente2 = new Cliente("Ana", "111222");
    Cliente cliente3 = new Cliente("Ana", "333444");

    assertTrue(cliente1.equals(cliente2));
    assertFalse(cliente1.equals(cliente3));
    LOG.info("Finalizado testCompararClientes");
}


@Test
public void testAsignarPagoAlVehiculo() {
    LOG.info("Iniciado testAsignarPagoAlVehiculo");
    Vehiculo moto = new Moto("MNO456", "Azul", "2021", TipoVehiculo.MOTO, 200, LocalDateTime.now().minusHours(2));
    Pago pago = new Pago(moto, LocalDateTime.now());

    assertNotNull(pago.getHoraSalida()); // corregido
    assertTrue(pago.getValor() > 0);
    LOG.info("Finalizado testAsignarPagoAlVehiculo");
}





























}