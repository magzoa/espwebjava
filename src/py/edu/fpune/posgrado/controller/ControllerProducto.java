package py.edu.fpune.posgrado.controller;

import py.edu.fpune.posgrado.infra.Controller;

public class ControllerProducto extends Controller {

	public ControllerProducto() throws Exception {
		super("Producto");
	}

	@Override
	public void goNew() throws Exception {
		request.setAttribute("nextPage","./producto/manterProducto.jsp");
	}

	@Override
	public void goFind() throws Exception {
		request.setAttribute("nextPage","./producto/consultarProducto.jsp");		
	}

	@Override
	public void save(Object obj) throws Exception {
		request.setAttribute("msg","Producto salvo com sucesso!");
		this.goNew();
	}

	@Override
	public void remove(Object obj) throws Exception {
		request.setAttribute("msg","Producto removido com sucesso!");
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

