package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;

import DominioRobot.Robot;

public class MejoraPage extends WebPage{
	private static final long serialVersionUID = 1l;
	
	private static IndexPage mainPage;
	private static Robot robotAMejorar;
	
	public MejoraPage(Robot robotAMejorar, IndexPage mainPage) {
		this.mainPage = mainPage;
		this.robotAMejorar = robotAMejorar;
	}
}
