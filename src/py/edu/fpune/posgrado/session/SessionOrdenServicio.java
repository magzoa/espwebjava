package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOOrdenServicio;
import py.edu.fpune.posgrado.infra.Session;

public class SessionOrdenServicio extends Session {

	public SessionOrdenServicio() {
		super(DAOOrdenServicio.class);
	}
}