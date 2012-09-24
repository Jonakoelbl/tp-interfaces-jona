package DominioRobot;

import java.util.List;
import java.util.Vector;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;


@TransactionalAndObservable
public class Jugador {
	private String nombre; 
	private String password;
	private List<Robot> misRobots = new Vector<Robot>();
	private Integer dinero = 3000;
	private Integer costo = 0;
	private Integer repararDeterioro = 0;
	private Integer deterioroDelRobot = 0;
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
		this.misRobots.add(unRobot);
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
			ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
		}
		else{
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");	
		}
	}
	
	public void reparar(Robot robot){
		this.dinero -= this.costo;
		robot.fuisteReparado(this.repararDeterioro);
		this.repararDeterioro = 0;
		this.setCosto(0);
	}

	public void mejorar(Robot robot, Mejora mejora){
		this.dinero -= mejora.getPrecio();
		robot.actualizarPoder(mejora);
	}
	
	public void vender(Robot robotAVender){
		this.misRobots.remove(robotAVender);
		this.dinero += robotAVender.getOferta();
		robotAVender.fuisteVendido();
	}
	
	//*****VALIDACIONES**************//
	
	public void validar(){
		if(this.dinero < this.costo)
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
		if(this.repararDeterioro > this.deterioroDelRobot)
			throw new UserException("El porcentaje a reparar supera al deterioro del robot");
		if (!this.ingresoNumero()) 
			throw new UserException("Debe ingresar número");
	}
	
	public boolean ingresoNumero() {
		return this.repararDeterioro != null;
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

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public void setRepararDeterioro(Integer deterioro) {
		this.repararDeterioro = deterioro;
	}

	public Integer getRepararDeterioro() {
		this.setCosto(this.calcularCostoDeReparacion(this.repararDeterioro));
		return repararDeterioro;
	}

	public Integer calcularCostoDeReparacion(Integer aReparar) {
		return 25 * aReparar;
	}

	public void setDeterioroDelRobot(Integer deterioroDelRobot) {
		this.deterioroDelRobot = deterioroDelRobot;
	}

	public Integer getDeterioroDelRobot() {
		return deterioroDelRobot;
	}
}
