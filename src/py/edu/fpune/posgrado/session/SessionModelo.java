package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOMarca;
import py.edu.fpune.posgrado.dao.DAOModelo;
import py.edu.fpune.posgrado.entity.Marca;
import py.edu.fpune.posgrado.entity.Modelo;
import py.edu.fpune.posgrado.infra.Session;

public class SessionModelo extends Session {

	public SessionModelo() {
		super(DAOModelo.class);
	}
	
	@Override
	public Object[] find(Object object, boolean bCommit) throws Exception {
		Object listModelo[] = super.find(object, false);
		
		DAOMarca daoMarca = new DAOMarca(this.getDAO().getConnection());
		
		for (int i = 0; i < listModelo.length; i++) {
			Modelo modelo = (Modelo) listModelo[i];
			Marca marca = (Marca) daoMarca.findByPrimary(modelo.getMarca());
			modelo.setMarca(marca);
		}
		if (bCommit) {
			this.getDAO().commit();
		}
		
		return listModelo;
	}
	
	@Override
	public Object detail(Object object, boolean bCommit) throws Exception {
		Modelo modelo = (Modelo) super.detail(object, false);
		
		DAOMarca daoMarca = new DAOMarca(this.getDAO().getConnection());
		Marca marca = (Marca) daoMarca.findByPrimary(modelo.getMarca());
		modelo.setMarca(marca);
		
		if (bCommit) {
			this.getDAO().commit();
		}
		
		return modelo;
	}
}