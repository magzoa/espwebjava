package py.edu.fpune.posgrado.infra;

public class Session {
	
	private DAO dao;
	protected Class <DAO> daoClass;
		
	public Session(Class <?> daoClass) {
		this.daoClass = (Class<DAO>) daoClass;
		this.dao = null;
	}
	
	public DAO getDAO() throws Exception {
		if (this.dao == null) {
			this.dao = this.daoClass.newInstance();
		}
		return dao;
	}

	public void save(Object object) throws Exception {
		this.save(object,true);	
	}
	
	public void save(Object object, boolean bCommit) throws Exception {
		this.getDAO().save(object);
		if (bCommit) {
			this.getDAO().commit();
		}
	}
	
	public void remove(Object object) throws Exception {
		this.remove(object,true);	
	}

	public void remove(Object object, boolean bCommit) throws Exception {
		this.getDAO().remove(object);
		if (bCommit) {
			this.getDAO().commit();
		}
	}
	
	public Object[] find(Object object) throws Exception {
		return this.find(object,true);
	}
	
	public Object[] find(Object object, boolean bCommit) throws Exception {
		Object list[] = this.getDAO().find(object);
		if (bCommit) {
			this.getDAO().commit();
		}
		return list;
	}
	
	public Object detail(Object object) throws Exception {
		return this.detail(object,true);
	}
	
	public Object detail(Object object, boolean bCommit) throws Exception {
		Object objectRetorno = this.getDAO().findByPrimary(object);
		if (bCommit) {
			this.getDAO().commit();
		}
		return objectRetorno;
	}
}
