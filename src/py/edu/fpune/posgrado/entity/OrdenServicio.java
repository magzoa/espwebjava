package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;
import py.edu.fpune.posgrado.annotation.Transient;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the orden_servicio database table.
 * 
 */
@Entity
@Table(name="orden_servicio")
//@NamedQuery(name="OrdenServicio.findAll", query="SELECT o FROM OrdenServicio o")
public class OrdenServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer idOrdenServicio;

	@Column(name="descripcion",type=DataType.STRING,length=100)
	private String descripcion;
	
	@Column(name="fecha",type=DataType.DATETIME)
	private Date fecha;

	@Column(name="total_prod",type=DataType.DOUBLE)
	private double totalProd;

	@Column(name="total_serv",type=DataType.DOUBLE)
	private double totalServ;

	//bi-directional many-to-one association to Vehiculo
	//@ManyToOne
	//@JoinColumn(name="id_vehiculo")
	@Column(name="id_vehiculo",type=DataType.OBJECT)
	private Vehiculo vehiculo;

	//bi-directional many-to-one association to OrdenServicioDetProducto
	//@OneToMany(mappedBy="ordenServicio")
	@Transient
	private List<OrdenServicioDetProducto> ordenServicioDetProductos;

	//bi-directional many-to-one association to OrdenServicioDetServicio
	//@OneToMany(mappedBy="ordenServicio")
	@Transient
	private List<OrdenServicioDetServicio> ordenServicioDetServicios;

	public OrdenServicio() {
	}

	

	public Integer getIdOrdenServicio() {
		return idOrdenServicio;
	}



	public void setIdOrdenServicio(Integer idOrdenServicio) {
		this.idOrdenServicio = idOrdenServicio;
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

	public List<OrdenServicioDetProducto> getOrdenServicioDetProductos() {
		return this.ordenServicioDetProductos;
	}

	public void setOrdenServicioDetProductos(List<OrdenServicioDetProducto> ordenServicioDetProductos) {
		this.ordenServicioDetProductos = ordenServicioDetProductos;
	}

	public OrdenServicioDetProducto addOrdenServicioDetProducto(OrdenServicioDetProducto ordenServicioDetProducto) {
		getOrdenServicioDetProductos().add(ordenServicioDetProducto);
		ordenServicioDetProducto.setOrdenServicio(this);

		return ordenServicioDetProducto;
	}

	public OrdenServicioDetProducto removeOrdenServicioDetProducto(OrdenServicioDetProducto ordenServicioDetProducto) {
		getOrdenServicioDetProductos().remove(ordenServicioDetProducto);
		ordenServicioDetProducto.setOrdenServicio(null);

		return ordenServicioDetProducto;
	}

	public List<OrdenServicioDetServicio> getOrdenServicioDetServicios() {
		return this.ordenServicioDetServicios;
	}

	public void setOrdenServicioDetServicios(List<OrdenServicioDetServicio> ordenServicioDetServicios) {
		this.ordenServicioDetServicios = ordenServicioDetServicios;
	}

	public OrdenServicioDetServicio addOrdenServicioDetServicio(OrdenServicioDetServicio ordenServicioDetServicio) {
		getOrdenServicioDetServicios().add(ordenServicioDetServicio);
		ordenServicioDetServicio.setOrdenServicio(this);

		return ordenServicioDetServicio;
	}

	public OrdenServicioDetServicio removeOrdenServicioDetServicio(OrdenServicioDetServicio ordenServicioDetServicio) {
		getOrdenServicioDetServicios().remove(ordenServicioDetServicio);
		ordenServicioDetServicio.setOrdenServicio(null);

		return ordenServicioDetServicio;
	}

}