package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOServicio;
import py.edu.fpune.posgrado.infra.Session;

public class SessionServicio extends Session {

	public SessionServicio() {
		super(DAOServicio.class);
	}
}