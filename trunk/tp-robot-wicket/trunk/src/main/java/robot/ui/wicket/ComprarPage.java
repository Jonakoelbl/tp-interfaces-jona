package robot.ui.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import robots.appModel.ComprarAppModel;
import robots.appModel.IndexJugador;
import DominioRobot.Robot;

public class ComprarPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private final IndexPage mainPage;
	private final ComprarAppModel comprarModel;

	
	public ComprarPage(IndexPage main, IndexJugador index) {

		this.mainPage = main;
		this.comprarModel = new ComprarAppModel(index.getJugador(), index.getTienda());
		Form<ComprarAppModel> compraForm = new Form<ComprarAppModel>("compraForm",new CompoundPropertyModel<ComprarAppModel	>(this.comprarModel));
		compraForm.add(new TextField<String>("oferta"));		
		add(compraForm);
		
		add(new ListView<Robot>("robots", new PropertyModel<List<Robot>>(comprarModel, "tienda.robotsEnVenta")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Robot> item) {
				
				final Robot robot = item.getModelObject();
				item.add(new Label("nombre-robot", robot.getNombreRobot()));
				Link<String> linkOfertar = new Link<String>("link-ofertar") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onClick() {
						ComprarPage.this.comprarModel.realizarOferta();
						ComprarPage.this.backToPage();
					}
				};
				item.add(linkOfertar);
			}
		});
	}
	protected void backToPage(){
		this.setResponsePage(mainPage);
	}
	
}
