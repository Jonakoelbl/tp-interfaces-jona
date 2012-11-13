package robot_ui_wicket.robot_ui_wicketweb;

import org.apache.wicket.protocol.http.WebApplication;

import robot.ui.wicket.ComprarPage;
import robot.ui.wicket.IndexPage;
import robot_ui_wicket.robot_ui_wicketweb.Start;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see robot_ui_wicket.robot_ui_wicketweb.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<IndexPage> getHomePage()
	{
		return IndexPage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		// add your configuration here
	}
}
