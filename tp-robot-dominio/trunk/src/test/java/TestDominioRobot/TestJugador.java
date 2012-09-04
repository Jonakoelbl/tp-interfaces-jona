package TestDominioRobot;

import junit.framework.Assert;

import org.junit.Test;

import DominioRobot.Jugador;


public class TestJugador {
	
	//Nota: reparar un robot cuesta 1 por 1 de performance.
	@Test
	public void RepararUnRobotConFullPerformance(){
		Jugador jugador = new Jugador("Jona");
		Robot robot1 = new Robot("RD2");
		
		jugador.repararUnRobot(robot1);
		
		Assert.assertTrue(jugador.getDinero() == 3000);
	}
	
	@Test
	public void RepararUnRobotConMitadDePerformance(){
		Jugador jugador = new Jugador("Jona");
		Robot rob = new Robot("RD3");
		Integer deterioro = 50;
		
		rob.setPerformance(deterioro);
		jugador.repararUnRobot(rob);
		
		Assert.assertTrue(jugador.getDinero() + deterioro == 3000);
	}
}
