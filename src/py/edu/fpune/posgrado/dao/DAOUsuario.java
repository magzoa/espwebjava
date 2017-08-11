package py.edu.fpune.posgrado.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import py.edu.fpune.posgrado.entity.Usuario;
import py.edu.fpune.posgrado.infra.DAO;
import py.edu.fpune.posgrado.infra.Factory;

public class DAOUsuario extends DAO {

	public DAOUsuario() throws Exception {
		super();
	}

	public DAOUsuario(Connection con) throws Exception {
		super(con);
	}
	
	public Object login(Object obj) throws Exception {
		if (obj instanceof Usuario) {
			Usuario objUsuario = (Usuario) obj;
			if ((objUsuario.getLogin() != null) &&
				(!objUsuario.getLogin().trim().equals("")) &&
				(objUsuario.getPassword() != null) &&
				(!objUsuario.getPassword().trim().equals(""))) {
				Statement stmt = this.con.createStatement();
				ResultSet rst = null;
				try {
					String sql = "select id,login,password " +
				                 "from usuario " +
							     "where login = '" + objUsuario.getLogin().replace("'","") + "' and " +
							     "password = '" + objUsuario.getPassword().replace("'","") + "'";
					System.out.println(sql);
					rst = stmt.executeQuery(sql);
					Object list[] = Factory.createByResultSet(rst, obj.getClass());
					if (list.length > 0) {
						return list[0];
					}
				} catch (Exception e) {
					try {
						this.rollback();
					} catch (Exception e2) {
					}
					throw e;
				} finally {
					try {
						stmt.close();
						if (rst != null) {
							rst.close();
						}
					} catch (Exception e) {
					}
				}
			}
		}
		return null;
	}
}
