package robot.ui.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;

import robots.appModel.IndexJugador;
import robots.appModel.VentaAppModel;

import DominioRobot.Robot;

public class VenderPage extends WebPage{

	private static final long serialVersionUID = 1l;
	
	private final IndexPage mainPage;
	private final VentaAppModel tiendaDeVenta;

	public VenderPage(IndexJugador indexJugador,Robot robotAVender, IndexPage indexPage) {
		this.mainPage = indexPage;
		this.tiendaDeVenta = new VentaAppModel(indexJugador.getJugador(), robotAVender, indexJugador.getTienda());
		Form<VentaAppModel> tiendaForm = new Form<VentaAppModel>("tiendaForm",new CompoundPropertyModel<VentaAppModel>(this.tiendaDeVenta));
		this.createPanelOfText(tiendaForm);
		this.createOnSummit(tiendaForm);
		this.add(tiendaForm);
	}

	protected void createOnSummit(Form<VentaAppModel> tiendaForm) {
		tiendaForm.add(new Button("Aceptar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				VenderPage.this.tiendaDeVenta.vender();
				VenderPage.this.backMainPage();
			}
		});
		tiendaForm.add(new Button("Cancelar"){
			private static final long serialVersionUID = 1L;
			@Override
			public void onSubmit() {
				VenderPage.this.backMainPage();
			}
		});
	}

	protected void backMainPage() {
		this.setResponsePage(mainPage);
	}

	protected void createPanelOfText(Form<VentaAppModel> tiendaForm) {
		tiendaForm.add(new Label("robotAVender.nombreRobot"));
		tiendaForm.add(new Label("robotAVender.nivelDeDeterioro"));
		tiendaForm.add(new Label("robotAVender.precio"));
		tiendaForm.add(new Label("ofertaDelSistema"));
	}
}
