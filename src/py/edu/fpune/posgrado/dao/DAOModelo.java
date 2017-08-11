package py.edu.fpune.posgrado.dao;

import java.sql.Connection;

import py.edu.fpune.posgrado.infra.DAO;

public class DAOModelo extends DAO {
	public DAOModelo() throws Exception {
		super();
	}

	public DAOModelo(Connection con) throws Exception {
		super(con);
	}
}
