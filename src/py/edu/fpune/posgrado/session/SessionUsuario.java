package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOUsuario;
import py.edu.fpune.posgrado.infra.Session;

public class SessionUsuario extends Session {
	
	public SessionUsuario() {
		super(DAOUsuario.class);
	}
	
	public Object login(Object obj) throws Exception {
		DAOUsuario dao = (DAOUsuario) this.getDAO();
		return dao.login(obj);
	}
	

}
