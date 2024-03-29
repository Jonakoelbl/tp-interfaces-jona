package robots.appModel;

import java.io.Serializable;
import java.util.List;

import DominioRobot.Jugador;
import DominioRobot.Robot;
import DominioRobot.Tienda;


public class IndexJugador implements Serializable{
	private Jugador jugador;
	private Tienda tienda;
	private String mensaje;

	public IndexJugador() {
		this.tienda = new Tienda();
		this.jugador = new Jugador("Pepe", "asd", new Robot(0, "Arturito"));
	}
	
	public List<Robot> getRobotsDelJugador(){
		return jugador.getMisRobots();
	}
	
	public List<Robot> getRobotsDeLosContrincantes(){
		return this.tienda.getAllRobotsForCompetition();
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
}
