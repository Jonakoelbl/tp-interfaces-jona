package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.aop.windows.TransactionalDialog;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;

import robots.appModel.JugadorInicio;

import DominioRobot.Mejora;
import DominioRobot.Robot;

public class SistemaMejoraWindow extends TransactionalDialog<JugadorInicio>{
	
	public SistemaMejoraWindow(WindowOwner owner, JugadorInicio model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Mejora");
		mainPanel.setLayout(new VerticalLayout());
		
		Panel primerPanel = new Panel(mainPanel).setLayout(new HorizontalLayout());
		new Label(primerPanel).setText("Poder de ");
		new Label(primerPanel).bindValueToProperty("robotSeleccionado.nombreRobot");
		new Label(primerPanel).bindValueToProperty("robotSeleccionado.poder");
		
		Panel segundoPanel = new Panel(mainPanel).setLayout(new VerticalLayout());
		
		Table<Mejora> table = new Table<Mejora>(segundoPanel,Mejora.class);
		table.bindItemsToProperty(JugadorInicio.MEJORAS_EN_VENTA);
		table.bindSelection(JugadorInicio.MEJORA_SELECCIONADO);
	
		Column<Mejora> performanceColumna = new Column<Mejora>(table);
		performanceColumna.setTitle("Descripcion");
		performanceColumna.setFixedSize(200);
		performanceColumna.bindContentsToProperty(Mejora.DESCRIPCION);
		
		Column<Mejora> nombreColumna = new Column<Mejora>(table);
		nombreColumna.setTitle("Mejora del poder");
		nombreColumna.setFixedSize(150);
		nombreColumna.bindContentsToProperty(Mejora.MEJORA_DE_PODER);
		
		Column<Mejora> poderColumna = new Column<Mejora>(table);
		poderColumna.setTitle("Precio");
		poderColumna.setFixedSize(150);
		poderColumna.bindContentsToProperty(Mejora.PRECIO);
		
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
