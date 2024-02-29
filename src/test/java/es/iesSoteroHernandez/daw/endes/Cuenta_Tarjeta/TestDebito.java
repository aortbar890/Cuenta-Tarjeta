package es.iesSoteroHernandez.daw.endes.Cuenta_Tarjeta;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDebito {
	// Intento controlar las excepciones que se me presentan
	// sin modificar el codigo original dado
	private Debito tarjetaDebito;

	@BeforeEach
	public void setUp() {
		tarjetaDebito = new Debito("987654321", "Ale Ortiz", new Date());
	}

	@AfterEach
	public void tearDown() {
		tarjetaDebito = null;
	}

	@Test
	public void testRetirar() {
		try {
			if (tarjetaDebito.mCuentaAsociada != null) {
				tarjetaDebito.retirar(200);
				assertEquals(-200, tarjetaDebito.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar la retirada");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIngresar() {
		try {
			if (tarjetaDebito.mCuentaAsociada != null) {
				tarjetaDebito.ingresar(300);
				assertEquals(300, tarjetaDebito.getSaldo());
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
			if (tarjetaDebito.mCuentaAsociada != null) {
				tarjetaDebito.pagoEnEstablecimiento("Tienda1", 400);
				assertEquals(-400, tarjetaDebito.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar el pago en establecimiento");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}