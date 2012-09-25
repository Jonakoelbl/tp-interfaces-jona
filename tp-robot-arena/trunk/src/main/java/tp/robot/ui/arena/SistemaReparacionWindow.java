package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import robots.appModel.JugadorInicio;
import robots.appModel.ReparacionAppModel;

public class SistemaReparacionWindow extends Dialog<ReparacionAppModel>{

	public SistemaReparacionWindow(WindowOwner owner, ReparacionAppModel model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Reparacion");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Deterioro del Robot");
		new Label(primerPanel).bindValueToProperty("robotAReparar.nivelDeDeterioro");
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(segundoPanel).setText("Reparar deterioro");
		new TextBox(segundoPanel).bindValueToProperty(ReparacionAppModel.DETERIORO_A_REPARAR);
		
		Panel tercerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(tercerPanel).setText("costo");
		new Label(tercerPanel).bindValueToProperty(ReparacionAppModel.COSTO);
	}

	@Override
	public void onAccept(Action action) {
		super.onAccept(new MessageSend(this.getModelObject(), "reparar"));
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
		.setCaption("Aceptar")
		.onClick(new MessageSend(this.getModelObject(), "accept"))
		.setAsDefault()
		.disableOnError();

		new Button(actions) //
		.setCaption("Cancelar")
		.onClick(new MessageSend(this, "cancel"));

	}
}
