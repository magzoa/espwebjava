package py.edu.fpune.posgrado.dao;

import java.sql.Connection;

import py.edu.fpune.posgrado.infra.DAO;

public class DAOFuncionario extends DAO{

	public DAOFuncionario() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DAOFuncionario(Connection con) throws Exception {
		super(con);
	}

}
