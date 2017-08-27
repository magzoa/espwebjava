package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerModelo extends Controller {

	public ControllerModelo() throws Exception {
		super("Modelo");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./modelo/manterModelo.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./modelo/consultarModelo.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Modelo guardado exitosamente!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Modelo eliminado exitosamente!");
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
