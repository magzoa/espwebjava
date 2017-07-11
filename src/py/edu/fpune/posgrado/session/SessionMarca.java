package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOMarca;
import py.edu.fpune.posgrado.infra.Session;

public class SessionMarca extends Session {

	public SessionMarca() {
		super(DAOMarca.class);
	}
}