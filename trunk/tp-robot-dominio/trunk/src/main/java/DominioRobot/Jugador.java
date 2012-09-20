package DominioRobot;

import java.util.List;
import java.util.Vector;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.TransactionalAndObservable;


@TransactionalAndObservable
public class Jugador {
	public static final String 
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
	
	public Jugador(String unNombre) {
		this.nombre = unNombre;
		this.misRobots.add(new Robot("Robotech"));
		Robot c = new Robot("Cortocircuito");
		c.setPropietario(this);
		c.setNivelDeDeterioro(58);
		this.misRobots.add(c);
		this.misRobots.add(new Robot("Arturito"));
	}
	
	public void comprar(Robot robot,Integer oferta){
		this.dinero -= oferta;
		robot.fuisteComprado(this);
		this.misRobots.add(robot);
		
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
	}
	
	public void reparar(Robot robot){
		this.dinero -= this.costo;
		robot.fuisteReparado(this.repararDeterioro);
		this.repararDeterioro = 0;
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
	}

	public void mejorar(Robot robot, Mejora mejora){
		this.dinero -= mejora.getPrecio();
		robot.actualizarPoder(mejora);
		ObservableUtils.forceFirePropertyChanged(this,"costo",this.getCosto());
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
		this.setCosto(this.calcularCostoDeReparacion(this.deterioroDelRobot));
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

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Tienda getTienda() {
		return tienda;
	}
}
