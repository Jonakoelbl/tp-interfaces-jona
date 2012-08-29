package DominioRobot;

import java.util.List;
import java.util.Vector;

public class Jugador {
	
	private String nombre; 
	private List<Robot> misRobots = new Vector<Robot>();
	private Integer dinero = 3000;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
	}
	
	public void repararUnRobot(Robot unRobot){
		Sistema.getInstancia().reparar(unRobot, this);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Robot> getMisRobots() {
		return misRobots;
	}

	public void setMisRobots(List<Robot> misRobots) {
		this.misRobots = misRobots;
	}

	public Integer getDinero() {
		return dinero;
	}

	public void setDinero(Integer dinero) {
		this.dinero = dinero;
	}
}
