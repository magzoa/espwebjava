package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;

import java.util.List;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
//@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private Integer cantidad;

	private String descripcion;

	private double valor;

	//bi-directional many-to-one association to OrdenServicioDetProducto
	//@OneToMany(mappedBy="producto")
	private List<OrdenServicioDetProducto> ordenServicioDetProductos;

	//bi-directional many-to-one association to VentaDetProducto
	//@OneToMany(mappedBy="producto")
	private List<VentaDetProducto> ventaDetProductos;

	public Producto() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<OrdenServicioDetProducto> getOrdenServicioDetProductos() {
		return this.ordenServicioDetProductos;
	}

	public void setOrdenServicioDetProductos(List<OrdenServicioDetProducto> ordenServicioDetProductos) {
		this.ordenServicioDetProductos = ordenServicioDetProductos;
	}

	public OrdenServicioDetProducto addOrdenServicioDetProducto(OrdenServicioDetProducto ordenServicioDetProducto) {
		getOrdenServicioDetProductos().add(ordenServicioDetProducto);
		ordenServicioDetProducto.setProducto(this);

		return ordenServicioDetProducto;
	}

	public OrdenServicioDetProducto removeOrdenServicioDetProducto(OrdenServicioDetProducto ordenServicioDetProducto) {
		getOrdenServicioDetProductos().remove(ordenServicioDetProducto);
		ordenServicioDetProducto.setProducto(null);

		return ordenServicioDetProducto;
	}

	public List<VentaDetProducto> getVentaDetProductos() {
		return this.ventaDetProductos;
	}

	public void setVentaDetProductos(List<VentaDetProducto> ventaDetProductos) {
		this.ventaDetProductos = ventaDetProductos;
	}

	public VentaDetProducto addVentaDetProducto(VentaDetProducto ventaDetProducto) {
		getVentaDetProductos().add(ventaDetProducto);
		ventaDetProducto.setProducto(this);

		return ventaDetProducto;
	}

	public VentaDetProducto removeVentaDetProducto(VentaDetProducto ventaDetProducto) {
		getVentaDetProductos().remove(ventaDetProducto);
		ventaDetProducto.setProducto(null);

		return ventaDetProducto;
	}

}