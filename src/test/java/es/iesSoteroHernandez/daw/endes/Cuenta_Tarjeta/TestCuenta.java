package es.iesSoteroHernandez.daw.endes.Cuenta_Tarjeta;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCuenta {

	private Cuenta cuenta;

	@BeforeEach
	public void setUp() {
		cuenta = new Cuenta("123456789", "Ale Ortiz");
	}
	
	@AfterEach
	public void tearDown() {
		cuenta = null;
	}

	@Test
	public void testIngresar() {
		try {
			cuenta.ingresar(100);
			assertEquals(100, cuenta.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRetirar() {
		try {
			cuenta.ingresar(100);
			cuenta.retirar(50);
			assertEquals(50, cuenta.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIngresarConConcepto() {
		try {
			cuenta.ingresar("Ingreso 1", 200);
			assertEquals(200, cuenta.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRetirarConConcepto() {
		try {
			cuenta.ingresar(100);
			cuenta.retirar("Retiro 1", 50);
			assertEquals(50, cuenta.getSaldo());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIngresarCantidadNegativa() {
		try {
			cuenta.ingresar(-50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRetirarCantidadNegativa() {
		try {
			cuenta.retirar(-50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testRetirarSaldoInsuficiente() {
		try {
			cuenta.retirar(50);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
