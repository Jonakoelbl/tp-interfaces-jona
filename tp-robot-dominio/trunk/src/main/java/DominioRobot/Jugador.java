package DominioRobot;

import java.util.List;
import java.util.Vector;

import org.uqbar.commons.utils.Observable;

@Observable
public class Jugador {
	
	private String nombre; 
	private List<Robot> misRobots = new Vector<Robot>();
	private Integer dinero = 3000;
	private Robot robotSeleccionado;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.comprarRobot(new Robot("Robotech"));
		Robot c = new Robot("Cortocircuito");
		c.setPerformance(58);
		this.comprarRobot(c);
		this.comprarRobot(new Robot("Arturito"));
	}
	
	public void comprarRobot(Robot unRobot){
		unRobot.darlePropietario(this);
		this.misRobots.add(unRobot);
	}
	
	public void repararSeleccionado() {
		this.repararUnRobot(this.robotSeleccionado);
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

	public void pagarGasto(Integer costo) {
		this.dinero -= costo;		
	}

	public Robot getRobotSeleccionado() {
		return robotSeleccionado;
	}

	public void setRobotSeleccionado(Robot robotSeleccionado) {
		this.robotSeleccionado = robotSeleccionado;
	}
}
