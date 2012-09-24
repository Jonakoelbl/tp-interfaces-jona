package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import robots.appModel.CompetirAppModel;
import robots.appModel.JugadorInicio;

import DominioRobot.Mejora;
import DominioRobot.Robot;

public class SistemaCompetirWindow extends TransactionalDialog<CompetirAppModel>{
	
	public SistemaCompetirWindow(WindowOwner owner, CompetirAppModel model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Ingresar Apuesta");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Poder de ");
		new Label(primerPanel).bindValueToProperty("robotSeleccionado.nombreRobot");
		new Label(primerPanel).bindValueToProperty("robotSeleccionado.poder");
		
		Panel sextoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(sextoPanel).setText("Poder de ");
		new Label(sextoPanel).bindValueToProperty("contrincanteSeleccionado.nombreRobot");
		new Label(sextoPanel).bindValueToProperty("contrincanteSeleccionado.poder");
		
		new Label(mainPanel).setText("Ingrese su apuesta");
		new TextBox(mainPanel).bindValueToProperty(CompetirAppModel.APUESTA);
		new Button(mainPanel)
				.setCaption("Competir")
				.onClick(new MessageSend(this.getModelObject(),"competirPorHonor"));
		
	}
	
//	@Override
//	protected void addActions(Panel actions) {
//		new Button(actions)
//		.setCaption("Aceptar")
//		.onClick(new MessageSend(this, "accept"))
//		.setAsDefault()
//		.disableOnError();
//
//		new Button(actions) //
//		.setCaption("Cancelar")
//		.onClick(new MessageSend(this, "cancel"));
//
//	}
	
	
}
