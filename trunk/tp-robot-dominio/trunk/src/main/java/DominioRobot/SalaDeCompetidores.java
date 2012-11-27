package DominioRobot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class SalaDeCompetidores implements Serializable{
	
	private List<Jugador> competidores = new ArrayList<Jugador>();
	
	public SalaDeCompetidores() {
		this.crearCompetidor("Jona", new Robot(0, "Skarner"));
		this.crearCompetidor("Diego", new Robot(0, "Buzz"));
		this.crearCompetidor("Fede", new Robot(0, "RobotCop"));
		this.crearCompetidor("Fulana", new Robot(0, "Orianna"));
		this.crearCompetidor("Lala", new Robot(0, "Arturito"));
	}

	private void crearCompetidor(String propietario, Robot robot) {
		Jugador jugador = new Jugador(propietario, "", robot);
		this.competidores.add(jugador);
	}
	
	public List<Robot> getRobotsCompetidores(){
		List<Robot> robots = new ArrayList<Robot>();
		for(Jugador j: this.competidores)
			robots.addAll(j.getMisRobots());
		return robots;
	}
}
