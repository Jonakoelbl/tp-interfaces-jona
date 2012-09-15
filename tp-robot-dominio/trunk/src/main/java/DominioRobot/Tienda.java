package DominioRobot;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

/**
 * La Tienda se encargar de brindar accesorios al Jugador tanto en comprar un robot como en mejorarlo
 * @author jonatan
 *
 */

@Observable
public class Tienda {
	public static final String 
		MEJORAS = "mejoras",
		ROBOTS_EN_VENTA = "robotsEnVenta",
		JUGADOR_LOGUEADO = "jugadorLogueado";
	
	private List<Mejora> mejoras = new ArrayList<Mejora>();
	private List<Robot> robotsEnVenta = new ArrayList<Robot>();
	private Jugador jugadorLogueado;
	
	public Tienda(Jugador jugador) {
		this.setJugadorLogueado(jugador);
		
		this.crearMejoras(new Mejora("Apredizaje de jiu-jitsu", 21, 250));
		this.crearMejoras(new Mejora("Mochila voladora de propulsion", 4, 96));
		this.crearMejoras(new Mejora("Lanza-cohetes teledirigidos", 13, 156));
		
		this.agregarRobots(new Robot("RBT1"));
		this.agregarRobots(new Robot("RBT2"));
		this.agregarRobots(new Robot("RBT3"));
		this.agregarRobots(new Robot("RBT4"));
	}
	
	
	
	protected void crearMejoras(Mejora mejora){
		this.mejoras.add(mejora);
	}
	
	protected void agregarRobots(Robot robot){
		this.robotsEnVenta.add(robot);
	}

	public List<Mejora> getMejoras() {
		return mejoras;
	}

	public List<Robot> getRobotsEnVenta() {
		return robotsEnVenta;
	}



	public void setJugadorLogueado(Jugador jugadorLogueado) {
		this.jugadorLogueado = jugadorLogueado;
	}



	public Jugador getJugadorLogueado() {
		return jugadorLogueado;
	}
}
