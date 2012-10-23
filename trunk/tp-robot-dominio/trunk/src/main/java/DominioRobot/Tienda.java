package DominioRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

/**
 * La Tienda se encargar de brindar accesorios al Jugador tanto en comprar un robot como en mejorarlo
 * @author - Diego A. Turchak
 *
 */
@Observable
public class Tienda {
	public static final String MEJORAS = "mejoras";
	public static final String ROBOTS_EN_VENTA = "robotsEnVenta";
	public static final String ROBOTS_EN_COMPETENCIA = "robotsEnCompetencia";
		
	private List<Mejora> mejoras = new ArrayList<Mejora>();
	private List<Robot> robotsEnVenta = new ArrayList<Robot>();
	private List<Jugador> jugadores = new ArrayList<Jugador>();
	private List<Robot> robotsEnCompetencia = new ArrayList<Robot>();
	private Integer oferta;
	private int id = 0;
	
	public Tienda() {
		
		this.crearMejoras(new Mejora("Apredizaje de jiu-jitsu", 21, 250));
		this.crearMejoras(new Mejora("Mochila voladora de propulsion", 4, 96));
		this.crearMejoras(new Mejora("Lanza-cohetes teledirigidos", 13, 156));
		
		this.agregarRobots(new Robot(0,"RBT1"));
		this.agregarRobots(new Robot(0,"RBT2"));
		this.agregarRobots(new Robot(0,"RBT3"));
		this.agregarRobots(new Robot(0,"RBT4"));
		
		this.creaNuevoUsuario("Diego", "vengoaganar");
		this.creaNuevoUsuario("Jona", "vengoapelear");
		this.creaNuevoUsuario("Tinogasta", "vengoacompetir");
		this.creaNuevoUsuario("LaFalda", "vengoaconseguirrobots");
		this.creaNuevoUsuario("Circense", "nosealoquevengo");
	}
	
	/**
	 * @Add a new player into the system...
	 * @param unNuevoJugador
	 * @return void
	 */
	
	public void agregarJugador(Jugador unNuevoJugador){
		this.getJugadores().add(unNuevoJugador);		
	}
	
	/**
	 * Sistema de logueo de un usuario
	 */
	public Jugador loguearUsuario(String usuario, String password){
		Jugador jugador = confirmarUsuario(usuario);
		if(confirmarPass(jugador, password))
			return jugador;
		throw new RuntimeException("El password de usuario "+usuario+" es incorrecta");
	}
	
	private boolean confirmarPass(Jugador usuario, String password) {
		return usuario.confirmar(password);
	}

	private Jugador confirmarUsuario(String usuario) {
		for (Jugador j : this.jugadores) {
			if(j.getNombre() == usuario)
				return j;
		}
		throw new RuntimeException("No existe el usuario "+usuario+" en el sistema");
	}

	public Robot getRobotContrincantes(int id){
		for (Robot robot : this.robotsEnCompetencia) {
			if(robot.getId() == id)
				return robot;
		}
		
		throw new RuntimeException("No existe el robot con la id "+id);
	}
	/**
	 * @Indicates if the user is login
	 * @param Jugador
	 * @return a boolean
	 */
	public Boolean isLogin(Jugador unJugador){
		return unJugador==this.getJugadorLogueado();
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
	/**
	 * @return the user that init session
	 */
	protected Jugador getJugadorLogueado(){
		return this.getJugadores().get(0);
	} 
	
	public Boolean ganaCompetencia(Robot unRetador, Robot unOponente){
		return (new Random().nextInt()) <= unRetador.getPoder() / (unRetador.getPoder() + unOponente.getPoder());
	}
	public void setDesgasteEnRobotRetador(Robot unRetador, Robot unOponente){
		unRetador.setNivelDeDeterioro(unRetador.getNivelDeDeterioro() + new Random().nextInt(1) * unOponente.getPoder() / (unRetador.getPoder() + unOponente.getPoder()));
	}

	public Integer getGanaciaDeLaPelea(Integer unaApuesta, Robot unRetador, Robot unOponente){
		return unaApuesta * (unRetador.getPoder() + unOponente.getPoder()) / unRetador.getPoder();
	}
	/**
	 * @The system pay the fight's money
	 */
	public void pagaLaGananciaDeLaApuesta(Integer unaApuesta, Robot unRetador, Robot unOponente){
		unRetador.getPropietario().setDinero(unRetador.getPropietario().getDinero() + this.getGanaciaDeLaPelea(unaApuesta, unRetador, unOponente));
	}

	public void competir(Integer unaApuesta, Robot unRetador, Robot unOponente){
		if(this.puedeApostar(unaApuesta, unRetador.getPropietario())){
			if(this.ganaCompetencia(unRetador, unOponente)){
				this.pagaLaGananciaDeLaApuesta(unaApuesta, unRetador, unOponente);
			}
			this.setDesgasteEnRobotRetador(unRetador, unOponente);
		}
		else{
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
		}
	}
	/**
	 * @Its validates if the player is in conditions for...
	 * @param unaApuesta
	 * @param unJugador
	 * @return Boolean
	 */
	public Boolean puedeApostar(Integer unaApuesta, Jugador unJugador){
		return unJugador.getDinero() >= unaApuesta;
	}
	/**
	 * @Create a new robot when a new user is registered into thetue system
	 * @param Jugador
	 * @return Robot
	 */
	public void creaNuevoUsuario(String unNombre,String unPassword){
		Jugador unNuevoJugador = new Jugador(unNombre,unPassword,this.creaUnNuevoRobot(unNombre));
		this.agregarJugador(unNuevoJugador);
	}
	
	public Robot creaUnNuevoRobot(String unNombre){
		return new Robot(this.id++,unNombre);
	}

	public List<Robot> getRobotsDeJugadores(){
		List<Robot> lista = new ArrayList<Robot> ();
		for(Jugador j : this.getJugadores()){
			if(!this.isLogin(j)){
				lista.addAll(j.getMisRobots());
			}
		}
		return lista;
	}
	
	public List<Robot> getAllRobotsForCompetition(){
		this.robotsEnCompetencia = new ArrayList<Robot>();
		this.robotsEnCompetencia.addAll(this.getRobotsEnVenta());
		this.robotsEnCompetencia.addAll(this.getRobotsDeJugadores());
		return this.robotsEnCompetencia;
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
	/**
	 * 
	 * @param jugador
	 * @param robotSeleccionado
	 * @param oferta
	 */
	public void venderleRobotAJugador(Jugador unJugador, Robot robotSeleccionado, Integer unaOferta) {
		if(this.aceptarOfertaDeJugador(unaOferta, robotSeleccionado)){
			unJugador.comprar(robotSeleccionado, unaOferta);
			this.robotsEnVenta.remove(robotSeleccionado);
		}
		else{
			this.cobraElFeedPorOfertar(unJugador, unaOferta);
		}
	}
	/**
	 * @The system realized the discount for the offer
	 * @param unJugador
	 * @param unaOferta
	 */
	public void cobraElFeedPorOfertar(Jugador unJugador, Integer unaOferta){
		unJugador.setDinero(unJugador.getDinero()- (unaOferta*2/100));
	}
	/**
	 * @The system allowed to sell the robots
	 * @param oferta
	 * @param unRobot
	 * @return
	 */
	protected Boolean aceptarOfertaDeJugador(Integer oferta, Robot unRobot){
		return new Random().nextDouble() <= 0.9 * Math.pow((oferta / unRobot.getPrecio()),2.0);
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

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() {
		return oferta;
	}

	public List<Robot> getRobotsEnCompetencia() {
		return robotsEnCompetencia;
	}

	public void setRobotsEnCompetencia(List<Robot> robotsEnCompetencia) {
		this.robotsEnCompetencia = robotsEnCompetencia;
	}

	public void setRobotsEnVenta(List<Robot> robotsEnVenta) {
		this.robotsEnVenta = robotsEnVenta;
	}

}
