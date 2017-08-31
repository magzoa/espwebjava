package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import java.util.List;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;
import py.edu.fpune.posgrado.annotation.Transient;


/**
 * The persistent class for the vehiculo database table.
 * 
 */
@Entity
@Table(name="vehiculo")
public class Vehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer idVehiculo;

	@Column(name="anho",type=DataType.INTEGER,unique=true)
	private Integer anho;

	@Column(name="color",type=DataType.STRING,length=100)
	private String color;
	
	@Column(name="placa",type=DataType.STRING,length=100)
	private String placa;

	@Transient
	@Column(name="orden_servicio",classListName="OrdenServicio",type=DataType.LIST)
	private List<OrdenServicio> ordenServicios;

	@Column(name="id_cliente",type=DataType.OBJECT)
	private Cliente cliente;


	@Column(name="id_modelo",type=DataType.OBJECT)
	private Modelo modelo;

	
	@Transient
	@Column(name="venta",classListName="Venta",type=DataType.LIST)
	private List<Venta> ventas;
	


	public Vehiculo() {
	}

	

	public Integer getIdVehiculo() {
		return idVehiculo;
	}



	public void setIdVehiculo(Integer idVehiculo) {
		this.idVehiculo = idVehiculo;
	}



	public Integer getAnho() {
		return this.anho;
	}

	public void setAnho(Integer anho) {
		this.anho = anho;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<OrdenServicio> getOrdenServicios() {
		return this.ordenServicios;
	}

	public void setOrdenServicios(List<OrdenServicio> ordenServicios) {
		this.ordenServicios = ordenServicios;
	}

	public OrdenServicio addOrdenServicio(OrdenServicio ordenServicio) {
		getOrdenServicios().add(ordenServicio);
		ordenServicio.setVehiculo(this);

		return ordenServicio;
	}

	public OrdenServicio removeOrdenServicio(OrdenServicio ordenServicio) {
		getOrdenServicios().remove(ordenServicio);
		ordenServicio.setVehiculo(null);

		return ordenServicio;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Modelo getModelo() {
		return this.modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta addVenta(Venta venta) {
		getVentas().add(venta);
		venta.setVehiculo(this);

		return venta;
	}

	public Venta removeVenta(Venta venta) {
		getVentas().remove(venta);
		venta.setVehiculo(null);

		return venta;
	}
	
	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", modelo=" + modelo
				+ ", placa=" + placa + ", A�o=" + anho +", Cliente=" + cliente + "]";
	}

}