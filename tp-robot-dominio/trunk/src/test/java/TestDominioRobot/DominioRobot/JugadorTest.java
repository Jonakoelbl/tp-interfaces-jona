package TestDominioRobot.DominioRobot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import static org.junit.Assert.assertThat;

public class JugadorTest {
	Jugador unJugador;
	Robot robotInicio;
	Mejora unaMejora;
	Robot unRobot;
	Robot unRobotB;
	@Before
	public void setUp() throws Exception {
		this.robotInicio = mock(Robot.class);
		when(this.robotInicio.getPropietario()).thenReturn(this.unJugador);
		this.unJugador = new Jugador("Diego","comovatodo",this.robotInicio);
		this.unaMejora = mock(Mejora.class);
		when(this.unaMejora.getPrecio()).thenReturn(10);
		this.unRobot = mock(Robot.class);
		this.unRobotB = mock(Robot.class);
		this.unJugador.comprar(this.unRobot, 107);
		when(this.unRobot.getPropietario()).thenReturn(this.unJugador);
		
	}

	@Test
	public void testVender() {
		Integer dinero = this.unJugador.getDinero() + 98;
		this.unJugador.vender(this.unRobot, 98);
		assertTrue(this.unJugador.getDinero()==dinero);
		assertFalse(this.unJugador.getMisRobots().contains(this.unRobot));
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
	public void testMejorar() {
		Integer saldo = this.unJugador.getDinero() - this.unaMejora.getPrecio();
		this.unJugador.mejorar(this.robotInicio, this.unaMejora);
		assertTrue(this.unJugador.getDinero()== saldo);
	}

}
