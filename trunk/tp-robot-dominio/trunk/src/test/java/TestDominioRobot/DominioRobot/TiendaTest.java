package TestDominioRobot.DominioRobot;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;
import static org.junit.Assert.assertThat;

public class TiendaTest {
	private Jugador unJugador;
	private Tienda unaTienda;
	private Robot unRobot;
	private Robot otroRobot;
	private Mejora unaMejora;
	@Before
	public void setUp() throws Exception {
		this.unaTienda = new Tienda();
		this.unJugador = mock(Jugador.class);
		this.unRobot = mock(Robot.class);
		when(this.unRobot.getPrecio()).thenReturn(300);
		when(this.unRobot.getPoder()).thenReturn(10);
		this.otroRobot = mock(Robot.class);
		when(this.otroRobot.getPoder()).thenReturn(10);
		this.unaMejora = mock(Mejora.class);
		when(this.unJugador.getDinero()).thenReturn(350);
	}


	@Test
	public void testAgregarJugador() {
		this.unaTienda.agregarJugador(this.unJugador);
		assertTrue(this.unaTienda.getJugadores().contains(this.unJugador));
	}

/**	@Test
	public void testCrearMejoras() {
		this.unaTienda.crearMejoras(this.unaMejora);
		assertTrue(this.unaTienda.getMejoras().contains(this.unaMejora));

	}

	@Test
	public void testAgregarRobots() {
		this.unaTienda.agregarRobots(this.unRobot);
		assertTrue(this.unaTienda.getRobotsEnVenta().contains(this.unRobot));
	}
**/

	@Test
	public void testGetGanaciaDeLaPelea() {
		Integer unaApuesta = 300;
		assertTrue(this.unaTienda.getGanaciaDeLaPelea(unaApuesta, this.unRobot, this.otroRobot)==600);
	}

	@Test
	public void testPuedeApostar() {
		Integer unaApuesta = 300;
		assertTrue(this.unaTienda.puedeApostar(unaApuesta, this.unJugador));		
	}


	@Test
	public void testVenderleRobotAJugador() {
		Integer unaOferta = 330;
		this.unaTienda.getRobotsEnVenta().add(this.unRobot);
		this.unaTienda.venderleRobotAJugador(this.unJugador,this.unRobot,unaOferta);
		assertFalse(this.unaTienda.getRobotsEnVenta().contains(this.unRobot));
	}
}
