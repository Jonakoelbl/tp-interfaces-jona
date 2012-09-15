package DominioRobot;

import java.io.Serializable;
import java.util.Random;
import org.uqbar.commons.utils.Observable;

/**
 * El sistema es el encargado de administrar:
 * - Compra/Venta de robots a un jugador
 * - Actualizar las mejoras a los jugadores para sus robots
 * - Realizar combate entre robots
 * @author jonatan
 *
 */
@Observable
public class Sistema implements Serializable{
	private static Sistema INSTANCIA; 
	
	public static Sistema getInstancia(){
		if(INSTANCIA == null)
			INSTANCIA = new Sistema();
		return INSTANCIA;
	}
	
	private Sistema(){}
	
	public Integer realizarOferta(Robot unRobot) {
		Integer random = 0;
		do{random = new Random().nextInt(20);}while(random < 2);
		return unRobot.getPrecio() * (random/100);
	}
	
	public Integer calcularCostoDeReparacion(Integer aReparar){
		return 25 * aReparar;
	}
	
	public void agregarMejora(Robot unRobot, Jugador unJugador){
		unJugador.setDinero(unJugador.getDinero() - unRobot.getMejoraSeleccionada().getPrecio());
		unRobot.actualizarPoder(unRobot.getMejoraSeleccionada().getMejoraDePoder());
	}
	
	public void venderRobot(Robot unRobot, Jugador unJugador){
		unJugador.setDinero(unJugador.getDinero() + unRobot.getOferta());
		unJugador.getMisRobots().remove(unRobot);
		//TODO agregar el robot sin propietario a la tienda
		unRobot.setPropietario(null);
	}
	
	public void repararRobot(Robot unRobot, Jugador unJugador){
		unJugador.validar();
		unJugador.setDinero(unJugador.getDinero() - unJugador.getCosto());
		unRobot.recibirReparacion(unJugador.getRepararDeterioro());
		unJugador.setRepararDeterioro(0);
		unJugador.setCosto(0);
	}
	
	public void comprarRobot(Robot unRobot, Jugador jugador){
		jugador.setDinero(jugador.getDinero() - unRobot.getPrecio());
		unRobot.asignarPropietario(jugador);
		jugador.getMisRobots().add(unRobot);
	}

}
