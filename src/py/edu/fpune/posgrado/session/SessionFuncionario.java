package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOFuncionario;
import py.edu.fpune.posgrado.infra.Session;

public class SessionFuncionario extends Session{

	public SessionFuncionario() {
		super(DAOFuncionario.class);
		// TODO Auto-generated constructor stub
	}

}
