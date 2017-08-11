package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerMarca extends Controller {

	public ControllerMarca() throws Exception {
		super("Marca");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./marca/manterMarca.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./marca/consultarMarca.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Marca salva com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Marca removida com sucesso!");
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
