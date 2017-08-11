package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerUsuario extends Controller {

	public ControllerUsuario() throws Exception {
		super("Usuario");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./usuario/manterUsuario.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./usuario/consultarUsuario.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Usuário salvo com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Usuário removido com sucesso!");
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
		
		if (this.action.equals("login")) {
			return true;
		}
		return false;
	}
	
	public void login(Object obj) throws Exception {
		if (obj != null) {
			this.request.getSession().setAttribute("UsuarioLogado", obj);
			request.setAttribute("nextPage","main.jsp");
		} else {
			request.setAttribute("msg","Usuário inválido!");
			request.setAttribute("nextPage","index.jsp");
		}
	}
	
}
