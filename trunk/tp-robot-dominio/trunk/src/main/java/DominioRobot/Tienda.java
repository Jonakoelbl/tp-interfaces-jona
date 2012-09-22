package DominioRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uqbar.commons.utils.Observable;

/**
 * La Tienda se encargar de brindar accesorios al Jugador tanto en comprar un robot como en mejorarlo
 * @author jonatan
 *
 */

@Observable
public class Tienda {
	public static final String MEJORAS = "mejoras";
	public static final String ROBOTS_EN_VENTA = "robotsEnVenta";
		
	private List<Mejora> mejoras = new ArrayList<Mejora>();
	private List<Robot> robotsEnVenta = new ArrayList<Robot>();
	private Integer oferta;
	
	public Tienda() {
		
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

	public void venderMejora(Jugador jugador, Robot robot,Mejora mejora){
		jugador.mejorar(robot, mejora);
	}
	
	public void comprarRobot(Jugador jugador, Robot robot,Integer oferta){
		if(aceptaOferta(oferta, robot)){
			jugador.vender(robot, oferta);
			robot.fuisteVendido();
			this.robotsEnVenta.add(robot);
		}
	}
	
	public void realizarOferta(Robot unRobot) {
		Integer random = 0;
		do{random = new Random().nextInt(20);}while(random <= 2);
		this.setOferta(unRobot.getPrecio() * (random/100));
	}

	public void venderleRobot(Jugador jugador, Robot robotSeleccionado, Integer oferta) {
		if(aceptaOferta(oferta, robotSeleccionado)){
			jugador.comprar(robotSeleccionado, oferta);
			this.robotsEnVenta.remove(robotSeleccionado);
		}
	}
	
	protected boolean aceptaOferta(Integer oferta, Robot robot){
		return (robot.getPrecio() * 0.1 >= oferta) || aceptarOfertaPrecioBase(oferta, robot.getPrecio()) ||
		this.aceptarPrecio75Por(oferta, robot.getPrecio()) || this.aceptarPrecio10Por(oferta, robot.getPrecio());			
	}
	
	protected boolean aceptarPrecio10Por(Integer oferta, Integer precioRobot) {
		return precioRobot * 0.1 >= oferta ? this.compraAleatorea(0.09, oferta, precioRobot) : false;
	}
	
	protected boolean aceptarPrecio75Por(Integer oferta, Integer precioRobot){
		return precioRobot * 0.9 >= oferta ? this.compraAleatorea(0.5, oferta, precioRobot) : false;
	}
	
	protected boolean aceptarOfertaPrecioBase(Integer oferta, Integer precioRobot){
		return precioRobot == oferta ?  (this.compraAleatorea(0.9, oferta, precioRobot)) : false;
	}
	
	protected boolean compraAleatorea(double porcentaje,Integer oferta, Integer precioRobot){
		return (Math.random()) <= (Math.pow((porcentaje * ((double)oferta / precioRobot)), 2));
	}
	
	public List<Mejora> getMejoras() {
		return mejoras;
	}

	public List<Robot> getRobotsEnVenta() {
		return robotsEnVenta;
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() {
		return oferta;
	}

}
