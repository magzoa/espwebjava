package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOVenta;
import py.edu.fpune.posgrado.infra.Session;

public class SessionVenta extends Session {

	public SessionVenta() {
		super(DAOVenta.class);
	}
}