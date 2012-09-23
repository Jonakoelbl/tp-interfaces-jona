package TestDominioRobot.DominioRobot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DominioRobot.Mejora;

public class MejoraTest {
	private String descripcion;
	private Integer mejoraDePoder;
	private Integer precio;
	private Mejora unaMejora;
	
	@Before
	public void setUp() throws Exception {
		this.descripcion = "Se tuvo que trabajar en perfecciòn de la motricidad fina";
		this.mejoraDePoder = 5;
		this.precio = 32;
		this.unaMejora = new Mejora(this.descripcion, this.mejoraDePoder, this.precio);
	}

	@Test
	public void testMejora() {
		assertEquals(this.unaMejora.getDescripcion(),this.descripcion);
		assertEquals(this.unaMejora.getMejoraDePoder(),this.mejoraDePoder);
		assertEquals(this.unaMejora.getPrecio(),this.precio);
	}

}
