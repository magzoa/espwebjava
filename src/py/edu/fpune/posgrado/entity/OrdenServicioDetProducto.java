package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the orden_servicio_det_producto database table.
 * 
 */
@Entity
@Table(name="orden_servicio_det_producto")
//@NamedQuery(name="OrdenServicioDetProducto.findAll", query="SELECT o FROM OrdenServicioDetProducto o")
public class OrdenServicioDetProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer idOrdenServicioDetProducto;

	//bi-directional many-to-one association to OrdenServicio
	//@ManyToOne
	//@JoinColumn(name="id_orden_servicio")
	@Column(name="id_orden_servicio",type=DataType.OBJECT)
	private OrdenServicio ordenServicio;

	//bi-directional many-to-one association to Producto
	//@ManyToOne
	//@JoinColumn(name="id_producto")
	
	@Column(name="id_producto",type=DataType.OBJECT)
	private Producto producto;

	public OrdenServicioDetProducto() {
	}

	

	public Integer getIdOrdenServicioDetProducto() {
		return idOrdenServicioDetProducto;
	}



	public void setIdOrdenServicioDetProducto(Integer idOrdenServicioDetProducto) {
		this.idOrdenServicioDetProducto = idOrdenServicioDetProducto;
	}



	public OrdenServicio getOrdenServicio() {
		return this.ordenServicio;
	}

	public void setOrdenServicio(OrdenServicio ordenServicio) {
		this.ordenServicio = ordenServicio;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}