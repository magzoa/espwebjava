package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the venta_det_servicio database table.
 * 
 */
@Entity
@Table(name="venta_det_servicio")
//@NamedQuery(name="VentaDetServicio.findAll", query="SELECT v FROM VentaDetServicio v")
public class VentaDetServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	//bi-directional many-to-one association to Servicio
	//@ManyToOne
	//@JoinColumn(name="id_servicio")
	private Servicio servicio;

	//bi-directional many-to-one association to Venta
	//@ManyToOne
	//@JoinColumn(name="id_venta")
	private Venta venta;

	public VentaDetServicio() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}