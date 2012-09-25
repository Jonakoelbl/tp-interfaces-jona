package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;

import robots.appModel.JugadorInicio;
import robots.appModel.VentaAppModel;

public class SistemaVentaWindow extends TransactionalDialog<VentaAppModel>{

	public SistemaVentaWindow(WindowOwner owner, VentaAppModel model) {
		super(owner, model);
		model.generarOferta();
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Venta");
		mainPanel.setLayout(new VerticalLayout());
		
		labelBind(mainPanel, "Nombre:         ", "robotAVender.nombreRobot");
		labelBind(mainPanel, "Estado:         ", "robotAVender.nivelDeDeterioro");
		labelBind(mainPanel, "Precio original:", "robotAVender.precio");
		labelBind(mainPanel, "OFERTA:         ", VentaAppModel.OFERTA_DEL_SISTEMA);
		
	}

	protected void labelBind(Panel mainPanel, String text, String property) {
		Panel newPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(newPanel).setText(text);
		new Label(newPanel).bindValueToProperty(property);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
		.setCaption("Aceptar")
		.onClick(new MessageSend(this, "accept"))
		.setAsDefault()
		.disableOnError();

		new Button(actions) //
		.setCaption("Cancelar")
		.onClick(new MessageSend(this, "cancel"));

	}
	
}
