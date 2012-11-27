package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.CompoundPropertyModel;

import robot_ui_wicket.robot_ui_wicketweb.FormManageException;
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
		Form<ReparacionAppModel> robotForm = new FormManageException<ReparacionAppModel> ("robotARepararForm",new CompoundPropertyModel<ReparacionAppModel>(this.tiendaDeReparacion));
		this.createFieldOfTextNivelDeDeterioro(robotForm);
		this.createTextBox(robotForm);
		this.createFieldOfTextCosto(robotForm);
		this.createButtonAction(robotForm);
		this.add(robotForm);
	}
	
	private void createButtonAction(Form<ReparacionAppModel> robotForm) {
		robotForm.add(new Button("calcular"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				RepararPage.this.tiendaDeReparacion.validarCalculoCosto();
			}
		});
		robotForm.add(new Button("Reparar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				RepararPage.this.tiendaDeReparacion.validar();
				RepararPage.this.tiendaDeReparacion.reparar();
				RepararPage.this.backMainPage();
			}
		});
		Button cancelar = new Button("Cancelar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				RepararPage.this.backMainPage();
			}
		};
		cancelar.setDefaultFormProcessing(false);
		robotForm.add(cancelar);
	}

	protected void backMainPage() {
		this.setResponsePage(mainPage);
	}

	private void createTextBox(Form<ReparacionAppModel> robotForm) {
		robotForm.add(new TextField<String>("deterioroAReparar"));
	}
	
	protected void createFieldOfTextCosto(Form<ReparacionAppModel> robotForm){
		robotForm.add(new Label("costo"));
	}
	
	protected void createFieldOfTextNivelDeDeterioro(Form<ReparacionAppModel> robotForm){
		robotForm.add(new Label("robotAReparar.nivelDeDeterioro"));
	}
}