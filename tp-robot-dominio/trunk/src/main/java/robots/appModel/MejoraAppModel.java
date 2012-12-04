package robots.appModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.UserException;
import org.uqbar.commons.utils.Observable;

import DominioRobot.Jugador;
import DominioRobot.Mejora;
import DominioRobot.Robot;
import DominioRobot.Tienda;

@Observable
public class MejoraAppModel implements Serializable{
	
	private Robot robotAMejorar;
	private Jugador jugador;
	private Tienda tienda;
	private Mejora mejoraSeleccionado;
	
	public MejoraAppModel(Jugador jugador, Robot robotSeleccionado, Tienda tienda) {
		this.jugador = jugador;
		this.robotAMejorar = robotSeleccionado;
		this.tienda = tienda;
	}
	
	public void mejorar(){
		this.validar();
		this.tienda.venderMejora(this.jugador, this.robotAMejorar, this.mejoraSeleccionado);
	}
	
	public void validar(){
		if(this.mejoraSeleccionado == null)
			throw new UserException("No se ha seleccionado ninguna mejora");
		if(this.jugador.getDinero() < this.mejoraSeleccionado.getPrecio())
			throw new UserException("El Jugador no tiene suficiente dinero para realizar la accion");
		if(this.robotAMejorar.getActualizacion().containsAll(getMejorasEnVenta()))
			throw new UserException("El robot tiene todas las actualizaciones");
	}
	
	/**
	 * Da un listado de las mejoras disponible para actualizar un robot, 
	 * filtrando con las actualizaciones que ya tiene el mismo. 
	 */
	public List<Mejora> getMejorasEnVenta(){
		List<Mejora> mejorasSegunRobot = new ArrayList<Mejora>();
		for(Mejora m:this.tienda.getMejoras()){
			if(!this.robotAMejorar.contieneActualizacion(m))
				mejorasSegunRobot.add(m);
		}
		return mejorasSegunRobot;
	}
	
	public void setRobotAMejorar(Robot robotAMejorar) {
		this.robotAMejorar = robotAMejorar;
	}
	public Robot getRobotAMejorar() {
		return robotAMejorar;
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

	public void setMejoraSeleccionado(Mejora mejoraSeleccionado) {
		this.mejoraSeleccionado = mejoraSeleccionado;
	}

	public Mejora getMejoraSeleccionado() {
		return mejoraSeleccionado;
	}
	
	
}
