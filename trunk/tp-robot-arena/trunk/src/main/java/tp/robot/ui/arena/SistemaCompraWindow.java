package tp.robot.ui.arena;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import DominioRobot.Robot;
import DominioRobot.Tienda;

import robots.appModel.JugadorInicio;

public class SistemaCompraWindow extends Dialog<JugadorInicio>{

	public SistemaCompraWindow(WindowOwner owner, JugadorInicio model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Compra De Robot");
		mainPanel.setLayout(new VerticalLayout());
		
		Table<Robot> table = new Table<Robot>(mainPanel, Robot.class);
		table.bindItemsToProperty(JugadorInicio.ROBOTS_EN_VENTA);
		table.bindSelection(JugadorInicio.ROBOT_SELECCIONADO);
		
		crearColumna(table,"Poder", Robot.PODER);
		crearColumna(table, "Estado", Robot.NIVEL_DE_DETERIORO);
		crearColumna(table, "Precio De Venta", Robot.PRECIO);
		
		new Label(mainPanel).setText("Ingrese su oferta");
		new TextBox(mainPanel).bindValueToProperty("tienda.oferta");
		new Button(mainPanel)
				.setCaption("Ofertar")
				.onClick(new MessageSend(this.getModelObject(),"realizarOferta"));
	}

	protected void crearColumna(Table<Robot> table, String titulo, String property) {
		Column<Robot> poderRobots = new Column<Robot>(table);
		poderRobots.setTitle(titulo);
		poderRobots.setFixedSize(150);
		poderRobots.bindContentsToProperty(property);
	}
}
