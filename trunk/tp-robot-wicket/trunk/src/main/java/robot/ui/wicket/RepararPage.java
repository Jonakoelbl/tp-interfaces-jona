package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;

import DominioRobot.Robot;

public class RepararPage extends WebPage{
	
	private static final long serialVersionUID = 1l;
	
	private final Robot robotAReparar;
	private final IndexPage mainPage;
	
	public RepararPage(Robot robot, IndexPage mainPage) {
		this.mainPage = mainPage;
		this.robotAReparar = robot;
	}
}
