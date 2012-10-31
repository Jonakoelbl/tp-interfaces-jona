package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import robots.appModel.ReparacionAppModel;

import DominioRobot.Jugador;
import DominioRobot.Robot;

public class RepararPage extends WebPage{
	
	private static final long serialVersionUID = 1l;
	
	private final ReparacionAppModel tiendaDeReparacion;
	private final IndexPage mainPage;
	
	public RepararPage(Robot robot, Jugador jugador, IndexPage mainPage) {
		this.mainPage = mainPage;
		this.tiendaDeReparacion = new ReparacionAppModel(jugador, robot);
		Form<ReparacionAppModel> robotForm = new Form<ReparacionAppModel> ("robotARepararForm",new CompoundPropertyModel<ReparacionAppModel>(this.tiendaDeReparacion));
		this.createFieldOfTextNivelDeDeterioro(robotForm);
		this.createTextBox(robotForm);
		this.createButtonAction(robotForm);
	}
	
	private void createButtonAction(Form<ReparacionAppModel> robotForm) {
		robotForm.add(new Button("calcular"){
			@Override
			public void onSubmit() {
				//TODO: refinir el costo...
				RepararPage.this.tiendaDeReparacion.calcularCosto();
			}
		});
		robotForm.add(new Button("Reparar"){
			@Override
			public void onSubmit() {
				RepararPage.this.tiendaDeReparacion.validar();
				RepararPage.this.tiendaDeReparacion.reparar();
				RepararPage.this.backMainPage();
			}
		});
		robotForm.add(new Button("Cancelar"){
			@Override
			public void onSubmit() {
				RepararPage.this.backMainPage();
			}
		});
	}

	protected void backMainPage() {
		mainPage.reloadPage();
		this.setResponsePage(mainPage);
	}

	private void createTextBox(Form<ReparacionAppModel> robotForm) {
		robotForm.add(new TextField<String>("deterioroAReparar"));
	}

	protected void createFieldOfTextNivelDeDeterioro(Form<ReparacionAppModel> robotForm){
		robotForm.add(new Label("NivelDeDeterioro"));
	}
}