package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerCliente extends Controller {

	public ControllerCliente() throws Exception {
		super("Cliente");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./cliente/manterCliente.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./cliente/consultarCliente.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Cliente salvo com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Cliente removido com sucesso!");
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
