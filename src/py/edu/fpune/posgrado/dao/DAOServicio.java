package py.edu.fpune.posgrado.dao;

import java.sql.Connection;

import py.edu.fpune.posgrado.infra.DAO;

public class DAOServicio extends DAO {

	public DAOServicio() throws Exception {
		super();
	}

	public DAOServicio(Connection con) throws Exception {
		super(con);
	}
}
