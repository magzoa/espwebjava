package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerFuncionario extends Controller {
	/*
	 * Controlador del funcionario
	 */
	public ControllerFuncionario() throws Exception {
		super("Funcionario");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./funcionario/editarFuncionario.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./funcionario/consultarFuncionario.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Funcionario guardado con exito!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Funcionario eliminado con exito!");
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
