package robots.appModel;

import DominioRobot.Jugador;
import DominioRobot.Tienda;

public class IndexJugador {
	private Jugador jugador;
	private Tienda tienda;

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
}
