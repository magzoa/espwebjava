package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerServicio extends Controller {

	public ControllerServicio() throws Exception {
		super("Servicio");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./servicio/manterServicio.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./servicio/consultarServicio.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Servicio salvo com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Servicio removido com sucesso!");
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
