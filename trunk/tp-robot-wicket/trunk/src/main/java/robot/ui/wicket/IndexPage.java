package robot.ui.wicket;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import DominioRobot.Robot;

import robots.appModel.IndexJugador;

public class IndexPage extends WebPage{
	
	private static final long serialVersionUID = 1l;
	
	private final IndexJugador indexJugador;
	
	public IndexPage() {
		this.indexJugador = new IndexJugador();
		Form<IndexJugador> indexJugador = new Form<IndexJugador>("IndexJugadorForm",new CompoundPropertyModel<IndexJugador>(this.indexJugador));
		this.createButtonComprar(indexJugador);
		this.createTableRobotPlayer(indexJugador);
		this.createTableOpponentPlayer(indexJugador);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	////////////////////Creacion de tabla de contrincantes//////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////
	private void createTableOpponentPlayer(Form<IndexJugador> parent) {
		parent.add(new PropertyListView<Robot>("Contrincantes"){
			@Override
			protected void populateItem(ListItem<Robot> item) {
				item.add(new Label("Propietario"));
				item.add(new Label("Nombre del Robot"));
				item.add(new Label("Nivel de deterioro"));
			}
		});
	}

	/////////////////////////////////////////////////////////////////////////////////////////
	////////////////////Vista de la tabla de los robots del jugador//////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	
	private void createTableRobotPlayer(Form<IndexJugador> parent) {
		parent.add(new PropertyListView<Robot>("misRobots") {

			@Override
			protected void populateItem(ListItem<Robot> item) {
				item.add(new Label("Nombre del Robot"));
				item.add(new Label("Poder de Ataque"));
				item.add(new Label("Nivel de deterioro"));
				
				item.add(createButtonReparar(item.getModelObject()));
				item.add(createButtonVender(item.getModelObject()));
				item.add(createButtonMejora(item.getModelObject()));
			}
		});
	}
	
	protected Component createButtonMejora(final Robot robot) {
		return new Button("Mejorar") {
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonMejorar(robot);
			}
		};
	}
	
	protected void goToButtonMejorar(Robot robotAMejorar){
		MejoraPage mejoraPage = new MejoraPage(robotAMejorar,this);
		this.setResponsePage(mejoraPage);
	}

	protected Component createButtonVender(final Robot robot) {
		return new Button("Reparar") {
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonVender(robot);
			}
		};		
	}

	protected void goToButtonVender(Robot robotAVender) {
		VenderPage venderPage = new VenderPage(robotAVender, this);
		this.setResponsePage(venderPage);
	}

	protected Component createButtonReparar(final Robot robot){
		return new Button("Reparar") {
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonReparar(robot);
			}
		};
	}

	protected void goToButtonReparar(Robot robotAReparar) {
		RepararPage repararPage = new RepararPage(robotAReparar, this);
		this.setResponsePage(repararPage);
	}

	protected void createButtonComprar(Form<IndexJugador> form){
		form.add(new Button("Comprar") {
			@Override
			public void onSubmit() {
				IndexPage.this.goToButtonComprar();
			}			
		});
	}

	protected void goToButtonComprar() {
		ComprarPage comprarPage = new ComprarPage(this);
		this.setResponsePage(comprarPage);
	}
}
