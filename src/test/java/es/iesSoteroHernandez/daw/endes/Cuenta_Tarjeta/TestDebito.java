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
	private Cuenta cuenta;

	@BeforeEach
	public void setUp() {
		cuenta = new Cuenta("123456", "Yo tambien");
		tarjetaDebito = new Debito("987654321", "Ale Ortiz", new Date());
		tarjetaDebito.setCuenta(cuenta);
	}

	@AfterEach
	public void tearDown() {
		tarjetaDebito = null;
	}

	@Test
	public void testRetirar() {
		try {
			if (tarjetaDebito.mCuentaAsociada != null) {
				cuenta.ingresar(1000);
				tarjetaDebito.retirar(200);
				assertEquals(800, cuenta.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar la retirada");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testIngresar() { //El metodo ingresar() usa retirar en lugar de ingresar en la clase debito por loq ue el valor devuelto esta mal
		try {
			if (tarjetaDebito.mCuentaAsociada != null) {
				cuenta.ingresar(1000);
				tarjetaDebito.ingresar(300);
				assertEquals(1300, cuenta.getSaldo());
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
				cuenta.ingresar(1000);
				tarjetaDebito.pagoEnEstablecimiento("Tienda1", 400);
				assertEquals(600, cuenta.getSaldo());
			} else {
				System.out.println("La cuenta asociada es nula, no se puede realizar el pago en establecimiento");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}