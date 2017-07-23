package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerOrdenServicio extends Controller {

	public ControllerOrdenServicio() throws Exception {
		super("OrdenServicio");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./orden_servicio/manterOrdenServicio.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./orden_servicio/consultarOrdenServicio.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Orden Servicio salva com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Orden Servicio removida com sucesso!");
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
