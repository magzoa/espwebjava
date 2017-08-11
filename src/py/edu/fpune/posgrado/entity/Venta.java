package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the venta database table.
 * 
 */
@Entity
//@NamedQuery(name="Venta.findAll", query="SELECT v FROM Venta v")
public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String descripcion;

	//@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="total_prod")
	private double totalProd;

	@Column(name="total_serv")
	private double totalServ;

	//bi-directional many-to-one association to Vehiculo
	//@ManyToOne
	//@JoinColumn(name="id_vehiculo")
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to VentaDetProducto
	//@OneToMany(mappedBy="venta")
	private List<VentaDetProducto> ventaDetProductos;

	//bi-directional many-to-one association to VentaDetServicio
	//@OneToMany(mappedBy="venta")
	private List<VentaDetServicio> ventaDetServicios;

	public Venta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotalProd() {
		return this.totalProd;
	}

	public void setTotalProd(double totalProd) {
		this.totalProd = totalProd;
	}

	public double getTotalServ() {
		return this.totalServ;
	}

	public void setTotalServ(double totalServ) {
		this.totalServ = totalServ;
	}

	public Vehiculo getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<VentaDetProducto> getVentaDetProductos() {
		return this.ventaDetProductos;
	}

	public void setVentaDetProductos(List<VentaDetProducto> ventaDetProductos) {
		this.ventaDetProductos = ventaDetProductos;
	}

	public VentaDetProducto addVentaDetProducto(VentaDetProducto ventaDetProducto) {
		getVentaDetProductos().add(ventaDetProducto);
		ventaDetProducto.setVenta(this);

		return ventaDetProducto;
	}

	public VentaDetProducto removeVentaDetProducto(VentaDetProducto ventaDetProducto) {
		getVentaDetProductos().remove(ventaDetProducto);
		ventaDetProducto.setVenta(null);

		return ventaDetProducto;
	}

	public List<VentaDetServicio> getVentaDetServicios() {
		return this.ventaDetServicios;
	}

	public void setVentaDetServicios(List<VentaDetServicio> ventaDetServicios) {
		this.ventaDetServicios = ventaDetServicios;
	}

	public VentaDetServicio addVentaDetServicio(VentaDetServicio ventaDetServicio) {
		getVentaDetServicios().add(ventaDetServicio);
		ventaDetServicio.setVenta(this);

		return ventaDetServicio;
	}

	public VentaDetServicio removeVentaDetServicio(VentaDetServicio ventaDetServicio) {
		getVentaDetServicios().remove(ventaDetServicio);
		ventaDetServicio.setVenta(null);

		return ventaDetServicio;
	}

}