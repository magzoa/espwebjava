package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the orden_servicio_det_servicio database table.
 * 
 */
@Entity
@Table(name="orden_servicio_det_servicio")
//@NamedQuery(name="OrdenServicioDetServicio.findAll", query="SELECT o FROM OrdenServicioDetServicio o")
public class OrdenServicioDetServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	//bi-directional many-to-one association to OrdenServicio
	//@ManyToOne
	//@JoinColumn(name="id_orden_servicio")
	private OrdenServicio ordenServicio;

	//bi-directional many-to-one association to Servicio
	//@ManyToOne
	//@JoinColumn(name="id_servicio")
	private Servicio servicio;

	public OrdenServicioDetServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrdenServicio getOrdenServicio() {
		return this.ordenServicio;
	}

	public void setOrdenServicio(OrdenServicio ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}