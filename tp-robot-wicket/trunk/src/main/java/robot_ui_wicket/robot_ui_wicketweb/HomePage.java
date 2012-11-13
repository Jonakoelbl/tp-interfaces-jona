package robot_ui_wicket.robot_ui_wicketweb;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import robot.ui.wicket.ComprarPage;
import robots.appModel.JugadorInicio;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
		super(parameters);
	
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
		
		Link<String> comprar = new Link<String>("compra") {
			private static final long serialVersionUID = 1L;
			@Override
			public void onClick() {
				//setResponsePage(new ComprarPage(HomePage.this, new JugadorInicio()));
			}
		};
		add(comprar);

    }
}
