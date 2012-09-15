package DominioRobot;

import java.util.Random;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.TransactionalAndObservable;

@TransactionalAndObservable
public class Robot {
	public static final String 
		NOMBRE_ROBOT = "nombreRobot",
		PROPIETARIO = "propietario",
		NIVEL_DE_DETERIORO = "nivelDeDeterioro",
		PODER_EFECTIVO = "poderEfectivo",
		PODER = "poder",
		PRECIO = "precio",
		MEJORA_SELECCIONADA = "mejoraSeleccionadas",
		OFERTA = "oferta";
	
	private String nombreRobot;
	private String propietario;
	private Integer nivelDeDeterioro = 0;
	private Integer poderEfectivo;
	private Integer poder ;
	private Integer precio;
	private Integer oferta;
	private Mejora mejoraSeleccionada;
	
	public Robot(String nombre) {
		this.nombreRobot = nombre;
		this.poder = new Random().nextInt(20);
		this.poderEfectivo = poder * (100 - nivelDeDeterioro) / 100;
		this.precio = this.poderEfectivo * 50;
	}
	
	public void actualizarPoder(Integer mejoraDePoder) {
		this.setPoder(this.poder + mejoraDePoder);		
	}
	
	public void asignarPropietario(Jugador jg){
		this.setPropietario(jg.getNombre());
	}

	public void pedirOferta(){
		this.setOferta(Sistema.getInstancia().realizarOferta(this));		
	}
	
	public void recibirReparacion(Integer puntoAReparar){
		this.setNivelDeDeterioro(this.getNivelDeDeterioro() - puntoAReparar);
	}
	//GETTERS AND SETTERS //
	public void setNombreRobot(String nombreRobot) {
		this.nombreRobot = nombreRobot;
	}

	public String getNombreRobot() {
		return nombreRobot;
	}

	public void setNivelDeDeterioro(Integer performance) {
		this.nivelDeDeterioro = performance;
	}

	public Integer getNivelDeDeterioro() {
		return nivelDeDeterioro;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPoder(Integer poder) {
		this.poder = poder;
	}

	public Integer getPoder() {
		return poder;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public void setPoderEfectivo(Integer poderEfectivo) {
		this.poderEfectivo = poderEfectivo;
	}

	public Integer getPoderEfectivo() {
		return poderEfectivo;
	}

	public void setMejoraSeleccionada(Mejora mejoraSeleccionada) {
		this.mejoraSeleccionada = mejoraSeleccionada;
	}

	public Mejora getMejoraSeleccionada() {
		return mejoraSeleccionada;
	}

	public void setOferta(Integer oferta) {
		this.oferta = oferta;
	}

	public Integer getOferta() { 
		return oferta;
	}

	
}
