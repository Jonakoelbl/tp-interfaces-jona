package TestDominioRobot.DominioRobot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DominioRobot.Jugador;
import DominioRobot.Robot;

public class JugadorTest {
	Jugador unJugador;
	Robot unRobot;
	Robot unRobotB;
	@Before
	public void setUp() throws Exception {
		this.unJugador = new Jugador("Diego");
		this.unRobot = mock(Robot.class);
		this.unRobotB = mock(Robot.class);
		this.unJugador.comprar(this.unRobot, 107);
		when(this.unRobot.getPropietario()).thenReturn(this.unJugador);
		
	}


	@Test
	public void testVender() {
		List <Robot> unaLista = this.unJugador.getMisRobots();
		Integer dinero = this.unJugador.getDinero() + 98;
		this.unJugador.vender(this.unRobot, 98);
		assertEquals(this.unJugador.getDinero(), dinero);
		assertFalse(this.unJugador.getMisRobots()==unaLista);
	}

	
	@Test
	public void testComprar() {
		Integer dinero = this.unJugador.getDinero()-100;
		List<Robot> lista = this.unJugador.getMisRobots();
		lista.add(this.unRobotB);
		this.unJugador.comprar(this.unRobotB, 100);
		assertEquals(this.unJugador.getMisRobots(),lista);
		assertEquals(this.unJugador.getDinero(),dinero);
	}

	@Test
	public void testReparar() {
		fail("Not yet implemented");
	}

	@Test
	public void testMejorar() {
		fail("Not yet implemented");
	}

	@Test
	public void testVenderRobot() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidar() {
		fail("Not yet implemented");
	}

	@Test
	public void testIngresoNumero() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcularCostoDeReparacion() {
		fail("Not yet implemented");
	}

}
