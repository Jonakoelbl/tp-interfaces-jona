package robot.ui.wicket;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.PropertyModel;

import robot_ui_wicket.robot_ui_wicketweb.FormManageException;
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
		Form<ComprarAppModel> compraForm = new FormManageException<ComprarAppModel>("compraForm",new CompoundPropertyModel<ComprarAppModel	>(this.comprarModel));
		compraForm.add(new TextField<String>("oferta"));		
		this.createButtonBack(compraForm);
		add(compraForm);
		
		compraForm.add(new ListView<Robot>("robots", new PropertyModel<List<Robot>>(comprarModel, "tienda.robotsEnVenta")) {

			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Robot> item) {
				
				final Robot robot = item.getModelObject();
				item.add(new Label("nombre-robot", robot.getNombreRobot()));
				item.add(new Label("precio",robot.getPrecio().toString()));
				SubmitLink linkOfertar = new SubmitLink("link-ofertar") {
					private static final long serialVersionUID = 1L;

					@Override
					public void onSubmit() {
						ComprarPage.this.comprarModel.setRobotAComprar(robot);
						ComprarPage.this.comprarModel.comprar();
						ComprarPage.this.backToPage();
					}
				};
				item.add(linkOfertar);
			}
		});
	}
	
	protected void  createButtonBack(Form<ComprarAppModel> form) {
		form.add(new Button("Volver"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				ComprarPage.this.backToPage();
			}
		});
	}
	
	protected void backToPage(){
		this.setResponsePage(mainPage);
	}
	
}
