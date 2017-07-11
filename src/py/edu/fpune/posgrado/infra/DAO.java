package py.edu.fpune.posgrado.infra;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DAO {
	
	protected Connection con;

	public DAO() throws Exception {
		this.con = DatabasePool.getInstance().getConnection();
	}

	public DAO(Connection con) throws Exception {
		this.con = con;
	}

	public Connection getConnection() {
		return con;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public void rollback() throws Exception {
		this.con.rollback();
		this.endTransaction();
	}

	public void commit() throws Exception {
		this.con.commit();
		this.endTransaction();
	}

	public void endTransaction() throws Exception {
		DatabasePool.getInstance().releaseConnection(this.con);
	}

	public void save(Object obj) throws Exception {
		if (obj != null) {
			Statement stmt = this.con.createStatement();
			ResultSet rst = null;
			String sql = "";
			try {
				if (Reflection.getIdFieldValue(obj) != null) {
					sql = Query.getSQLUpdate(obj);
					System.out.println(sql);
					stmt.execute(sql);
				} else {
					sql = Query.getSQLInsert(obj);
					System.out.println(sql);
					stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
					rst = stmt.getGeneratedKeys();
					if (rst.next()) {
						Reflection.setIdFieldValue(obj, rst.getInt(1));
					}
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

	public void remove(Object obj) throws Exception {
		if ((obj != null) && (Reflection.getIdFieldValue(obj) != null)) {
			Statement stmt = this.con.createStatement();
			try {
				String sql = Query.getSQLDelete(obj);
				System.out.println(sql);
				stmt.execute(sql);
			} catch (Exception e) {
				try {
					this.rollback();
				} catch (Exception e2) {
				}
				throw e;
			} finally {
				try {
					stmt.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public Object[] find(Object obj) throws Exception {
		Statement stmt = this.con.createStatement();
		ResultSet rst = null;
		try {
			String sql = Query.getSQLSelect(obj);
			System.out.println(sql);
			rst = stmt.executeQuery(sql);
			return Factory.createByResultSet(rst, obj.getClass());
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

	public Object findByPrimary(Object obj) throws Exception {
		if ((obj != null) && (Reflection.getIdFieldValue(obj) != null)) {
			Object objId = obj.getClass().newInstance();
			Reflection.setIdFieldValue(objId, Reflection.getIdFieldValue(obj));
			Object list[] = this.find(objId);
			if (list.length > 0) {
				return list[0];
			}
		}
		return null;
	}
}