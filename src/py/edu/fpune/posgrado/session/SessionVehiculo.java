package py.edu.fpune.posgrado.session;

import py.edu.fpune.posgrado.dao.DAOModelo;
import py.edu.fpune.posgrado.dao.DAOVehiculo;

import java.util.ArrayList;

import py.edu.fpune.posgrado.dao.DAOCliente;
import py.edu.fpune.posgrado.dao.DAOMarca;
import py.edu.fpune.posgrado.entity.Cliente;
import py.edu.fpune.posgrado.entity.Modelo;
import py.edu.fpune.posgrado.entity.Vehiculo;
import py.edu.fpune.posgrado.infra.Query;
import py.edu.fpune.posgrado.infra.Session;

public class SessionVehiculo extends Session {

	public SessionVehiculo() {
		super(DAOVehiculo.class);
	}

	@Override
	public Object[] find(Object object, boolean bCommit) throws Exception {
		Object listVehiculo[] = super.find(object, false);

		DAOModelo daoModelo = new DAOModelo(this.getDAO().getConnection());
		DAOCliente daoCliente = new DAOCliente(this.getDAO().getConnection());

		for (int i = 0; i < listVehiculo.length; i++) {
			Vehiculo vehiculo = (Vehiculo) listVehiculo[i];
			Modelo modelo = (Modelo) daoModelo.findByPrimary(vehiculo.getModelo());
			Cliente cliente = (Cliente) daoCliente.findByPrimary(vehiculo.getCliente());
			vehiculo.setModelo(modelo);
			vehiculo.setCliente(cliente);
			/*
			 * vehiculo.setAnho(vehiculo.getAnho()); vehiculo.setPlaca(vehiculo.getPlaca());
			 * vehiculo.setColor(vehiculo.getColor());
			 */
		}
		if (bCommit) {
			this.getDAO().commit();
		}
		int i = 0;
		while (i < listVehiculo.length) {
			System.out.println(listVehiculo[i].toString());
			i++;
		}

		return listVehiculo;
	}

	@Override
	public Object detail(Object object, boolean bCommit) throws Exception {
		Vehiculo vehiculo = (Vehiculo) super.detail(object, false);

		DAOModelo daoModelo = new DAOModelo(this.getDAO().getConnection());
		Modelo modelo = (Modelo) daoModelo.findByPrimary(vehiculo.getModelo());
		vehiculo.setModelo(modelo);
		DAOCliente daoCliente = new DAOCliente(this.getDAO().getConnection());
		Cliente cliente = (Cliente) daoCliente.findByPrimary(vehiculo.getCliente());
		vehiculo.setCliente(cliente);
		/*
		 * vehiculo.setAnho(vehiculo.getAnho()); vehiculo.setPlaca(vehiculo.getPlaca());
		 * vehiculo.setColor(vehiculo.getColor());
		 */
		if (bCommit) {
			this.getDAO().commit();
		}
		return vehiculo;
	}

}