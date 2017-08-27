package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerVenta extends Controller {

	public ControllerVenta() throws Exception {
		super("Venta");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./venta/manterVenta.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./venta/consultarVenta.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Venta salva com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Venta removida com sucesso!");
		this.goFind();
	}

	@Override
	public void detail(Object obj) throws Exception {
		request.setAttribute("object",obj);
		this.goNew();
	}

	@Override
	public boolean isLogged() throws Exception {
		if (this.request.getSession().getAttribute("UsuarioLogado") != null) {
			return true;
		}
		return false;
	}
}
