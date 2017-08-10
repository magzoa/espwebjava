package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOProducto;
import py.edu.fpune.posgrado.infra.Session;

public class SessionProducto extends Session {

	public SessionProducto() {
		super(DAOProducto.class);
	}
}