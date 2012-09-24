package TestDominioRobot.DominioRobot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	Mejora unaMejora;
	Robot unRobot;
	Jugador unUsuario;
	Integer puntosReparacion;
	@Before
	public void setUp() throws Exception {
		this.unRobot = new Robot("Diego");
		this.puntosReparacion = 3;
		this.unRobot.setNivelDeDeterioro(5);
		this.unaMejora = mock(Mejora.class);
		when(this.unaMejora.getMejoraDePoder()).thenReturn(3);
		this.unUsuario = mock(Jugador.class);

		
	}

	@Test
	public void testRobot() {
		assertEquals(this.unRobot.getNombreRobot(),"Diego");
		Integer precioDeseado = this.unRobot.getPoderEfectivo()*50;
		assertEquals(this.unRobot.getPrecio(),precioDeseado);
	}

	@Test
	public void testActualizarPoder() {
		Integer poder = this.unRobot.getPoder() + this.unaMejora.getMejoraDePoder();
		this.unRobot.actualizarPoder(this.unaMejora);
		assertEquals(this.unRobot.getPoder(),poder);
	}

	@Test
	public void testFuisteReparado() {
		Integer nivelDeterioroDeseado = this.unRobot.getNivelDeDeterioro() - this.puntosReparacion;;
		this.unRobot.fuisteReparado(this.puntosReparacion);
		assertEquals(this.unRobot.getNivelDeDeterioro(),nivelDeterioroDeseado);
	}

	@Test
	public void testFuisteComprado() {
		this.unRobot.fuisteComprado(this.unUsuario);
		assertEquals(this.unRobot.getPropietario(),this.unUsuario);
	}

	@Test
	public void testFuisteVendido() {
		this.unRobot.fuisteComprado(this.unUsuario);
		this.unRobot.fuisteVendido();
		assertEquals(this.unRobot.getPropietario(),null);
	}

}
