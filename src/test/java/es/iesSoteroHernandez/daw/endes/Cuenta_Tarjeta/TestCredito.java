package es.iesSoteroHernandez.daw.endes.Cuenta_Tarjeta;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCredito {
	// Intento controlar las excepciones que se me presentan
	// sin modificar el codigo original dado
	private Credito tarjeta;
	private Cuenta cuenta;

	@BeforeEach
	public void setUp() {
		cuenta = new Cuenta("123456", "Yo");
		tarjeta = new Credito("123456789", "Ale Ortiz", new Date(0), 1000);
		tarjeta.setCuenta(cuenta);
	}

	@AfterEach
	public void tearDown() {
		tarjeta = null;
	}

	@Test
	public void testRetirar() { // Devuelve unicamente la comision
		try {
			cuenta.ingresar(1000);
			tarjeta.retirar(500);
			assertEquals(25, tarjeta.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIngresar() {
		try {
			if (tarjeta.mCuentaAsociada != null) {
				cuenta.ingresar(1000);
				tarjeta.ingresar(200);
				assertEquals(1200, cuenta.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar el ingreso");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testPagoEnEstablecimiento() {
		try {
			cuenta.ingresar(1000);
			tarjeta.pagoEnEstablecimiento("Compra1", 100);
			assertEquals(900, tarjeta.getCreditoDisponible());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testLiquidar() {
		try {
			if (tarjeta.mCuentaAsociada != null) {
				cuenta.ingresar(1000);
				tarjeta.ingresar(500);
				tarjeta.liquidar(1, 2024);
				assertEquals(1500, cuenta.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar el ingreso");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
