package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the venta_det_producto database table.
 * 
 */
@Entity
@Table(name="venta_det_producto")
//@NamedQuery(name="VentaDetProducto.findAll", query="SELECT v FROM VentaDetProducto v")
public class VentaDetProducto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	//bi-directional many-to-one association to Producto
	//@ManyToOne
	//@JoinColumn(name="productoid")
	private Producto producto;

	//bi-directional many-to-one association to Venta
	//@ManyToOne
	//@JoinColumn(name="id_venta")
	private Venta venta;

	public VentaDetProducto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return this.venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}