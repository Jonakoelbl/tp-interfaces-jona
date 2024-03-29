package DominioRobot;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;


@Observable
public class Jugador implements Serializable{
	private String nombre; 
	private String password;
	private List<Robot> misRobots = new Vector<Robot>();
	private Integer dinero = 4000;
	private List<Robot> misContrincantes = new Vector<Robot>();
	/**
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.misRobots.add(new Robot("Robotech"));
		Robot c = new Robot("Cortocircuito");
		c.setPropietario(this);
		c.setNivelDeDeterioro(58);
		this.misRobots.add(c);
		this.misRobots.add(new Robot("Arturito"));
	}**/
	
	/**
	 * @Create an user in the system an it give him a new Robot...
	 * @param unNombre
	 * @param unPassword
	 * @param unRobot
	 * 
	 */
	public Jugador(String unNombre,String unPassword,Robot unRobot) {
		this.nombre = unNombre;
		this.password = unPassword;
		unRobot.setPropietario(this);
		unRobot.setNivelDeDeterioro(50);
		this.misRobots.add(unRobot);
		this.misContrincantes = this.getMisContrincantes();
	}
	
	public void vender(Robot robot, Integer oferta){
		this.setDinero(this.getDinero() + oferta);
		this.getMisRobots().remove(robot);
	}
	
	public void comprar(Robot robot,Integer oferta){
		if(this.getDinero()>=oferta){
			this.dinero -= oferta;
			robot.fuisteComprado(this);
			this.getMisRobots().add(robot);	
		}
		else{
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");	
		}
	}
	
	public void repararDeterioroDelRobot(Robot robot, int repararDeterioro, int costo){
		this.dinero -= costo;
		robot.fuisteReparado(repararDeterioro);
	}

	public void comprarMejoraParaRobot(Robot robot, Mejora mejora){
		this.dinero -= mejora.getPrecio();
		robot.actualizarPoder(mejora);
	}
	
	public void vender(Robot robotAVender){
		this.misRobots.remove(robotAVender);
		this.dinero += robotAVender.getOferta();
		robotAVender.fuisteVendido();
	}
	
	//*****	Accesors *****//
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


	public boolean confirmar(String password) {
		return this.password.equals(password);
	}

	public void setMisContrincantes(List<Robot> misContrincantes) {
		this.misContrincantes = misContrincantes;
	}

	public List<Robot> getMisContrincantes() {
		return misContrincantes;
	}

	public Robot getMiRobot(int id) {
		Robot r = null;
		for (Robot robot : this.misRobots) {
			if(r.getId() == id)
				r = robot;
		}
		return r;
	}
}
