package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;

import DominioRobot.Robot;

import robots.appModel.CompetirAppModel;
import robots.appModel.IndexJugador;

public class CompetirPage extends WebPage {
	
	private static final long serialVersionUID = 1l;
	
	private final CompetirAppModel battleground;
	private final IndexPage mainPage;
	
	public CompetirPage(IndexJugador indexJugador, Robot robotPlayer, Robot robotOpponent, IndexPage mainPage) {
		this.mainPage = mainPage;
		this.battleground = new CompetirAppModel(indexJugador.getJugador(), robotPlayer, robotOpponent, indexJugador.getTienda());
		
	}
}
