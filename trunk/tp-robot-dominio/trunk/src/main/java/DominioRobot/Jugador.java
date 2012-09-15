package DominioRobot;

import java.util.List;
import java.util.Vector;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;


@TransactionalAndObservable
public class Jugador {
	public static final String 
		ROBOT_SELECCIONADO = "robotSeleccionado",
		MISROBOTS = "misRobots",
		NOMBRE = "nombre",
		DINERO = "dinero",
		COSTO = "costo",
		REPARAR_DETERIORO = "repararDeterioro",
		DETERIORO_DEL_ROBOT = "deterioroDelRobot";
	
	private Tienda tienda = new Tienda(this);
	private String nombre; 
	private List<Robot> misRobots = new Vector<Robot>();
	private Integer dinero = 3000, costo = 0,
					repararDeterioro = 0,
					deterioroDelRobot = 0;
	private Robot robotSeleccionado;
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.misRobots.add(new Robot("Robotech"));
		Robot c = new Robot("Cortocircuito");
		c.setNivelDeDeterioro(58);
		this.misRobots.add(c);
		this.misRobots.add(new Robot("Arturito"));
	}
	
	public void comprarRobot(){
		Sistema.getInstancia().comprarRobot(robotSeleccionado, this);
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
	}
	
	public void repararUnRobot(){
		Sistema.getInstancia().repararRobot(this.robotSeleccionado, this);
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
	}

	public void mejorarUnRobot(){
		Sistema.getInstancia().agregarMejora(this.robotSeleccionado, this);
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
	}
	
	public void venderUnRobot(){
		Sistema.getInstancia().venderRobot(this.robotSeleccionado, this);
	}
	//*****VALIDACIONES**************//
	
	public void validar(){
		if(this.dinero < this.costo)
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
		if(this.deterioroDelRobot == 0)
			throw new UserException("El robot "+this.robotSeleccionado.getNombreRobot()+
									" no se encuentra deteriorado");
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

	public Robot getRobotSeleccionado() {
		return robotSeleccionado;
	}

	public void setRobotSeleccionado(Robot robotSeleccionado) {
		this.setDeterioroDelRobot(robotSeleccionado.getNivelDeDeterioro());
		this.robotSeleccionado = robotSeleccionado;
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
		this.setCosto(Sistema.getInstancia().calcularCostoDeReparacion(this.repararDeterioro));
		return repararDeterioro;
	}

	public void setDeterioroDelRobot(Integer deterioroDelRobot) {
		this.deterioroDelRobot = deterioroDelRobot;
	}

	public Integer getDeterioroDelRobot() {
		return deterioroDelRobot;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Tienda getTienda() {
		return tienda;
	}
}
