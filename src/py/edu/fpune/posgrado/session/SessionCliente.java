package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOCliente;
import py.edu.fpune.posgrado.dao.DAOMarca;
import py.edu.fpune.posgrado.infra.Session;

public class SessionCliente extends Session {

	public SessionCliente() {
		super(DAOCliente.class);
	}
}