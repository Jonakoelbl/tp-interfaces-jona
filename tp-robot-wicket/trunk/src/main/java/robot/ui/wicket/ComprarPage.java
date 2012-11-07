/**
 * 
 */
package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import robots.appModel.ComprarAppModel;
import robots.appModel.IndexJugador;
import robots.appModel.JugadorInicio;
import DominioRobot.Robot;

public class ComprarPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private final WebPage mainPage;
	private final ComprarAppModel comprarModel;

	public ComprarPage(WebPage main, IndexJugador index) {
		this.mainPage = main;
		this.comprarModel = new ComprarAppModel(index.getJugador(),	index.getTienda());
		Form<ComprarAppModel> compraForm = 
			new Form<ComprarAppModel>("compraForm", new CompoundPropertyModel<ComprarAppModel>(this.comprarModel));
		this.createTableRobotsForSale(compraForm);
		this.createButton(compraForm);
		this.add(compraForm);

	}
	
	protected void createButton(Form<ComprarAppModel> compraForm) {
		compraForm.add(new Button("Realizar una oferta"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				ComprarPage.this.comprarModel.realizarOferta();
			}
		});
		compraForm.add(new Button("Aceptar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				ComprarPage.this.comprarModel.comprar();
			}
		});
	}

	@SuppressWarnings("serial")
	protected void createTableRobotsForSale(Form<ComprarAppModel> compraForm) {
		RadioGroup<Robot> group =new RadioGroup<Robot>("robotAComprar");
		compraForm.add(group);

		ListView<Robot> robots=new ListView<Robot>("robots", this.comprarModel.getRobotsEnVenta()) { 
		    protected void populateItem(ListItem<Robot> item) {
		      item.add(new Radio<Robot>("robot", item.getModel()));
		      item.add(new Label("nombreRobot", new PropertyModel<Robot>(item.getModel(), "nombreRobot")));
		    }
		   };
		group.add(robots);
	}
}
