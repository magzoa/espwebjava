package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import java.util.List;
import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@Table(name="producto")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer id;

	private Integer cantidad;

	private String descripcion;

	private Double valor;

	private List<OrdenServicioDetProducto> ordenServicioDetProductos;

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

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
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