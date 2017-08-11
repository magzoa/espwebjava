package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;

import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
//@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String descripcion;

	@Column(name="valor_hora")
	private double valorHora;

	//bi-directional many-to-one association to OrdenServicioDetServicio
	//@OneToMany(mappedBy="servicio")
	private List<OrdenServicioDetServicio> ordenServicioDetServicios;

	//bi-directional many-to-one association to ServicioFuncionario
	//@OneToMany(mappedBy="servicio")
	private List<ServicioFuncionario> servicioFuncionarios;

	//bi-directional many-to-one association to VentaDetServicio
	//@OneToMany(mappedBy="servicio")
	private List<VentaDetServicio> ventaDetServicios;

	public Servicio() {
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

	public double getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public List<OrdenServicioDetServicio> getOrdenServicioDetServicios() {
		return this.ordenServicioDetServicios;
	}

	public void setOrdenServicioDetServicios(List<OrdenServicioDetServicio> ordenServicioDetServicios) {
		this.ordenServicioDetServicios = ordenServicioDetServicios;
	}

	public OrdenServicioDetServicio addOrdenServicioDetServicio(OrdenServicioDetServicio ordenServicioDetServicio) {
		getOrdenServicioDetServicios().add(ordenServicioDetServicio);
		ordenServicioDetServicio.setServicio(this);

		return ordenServicioDetServicio;
	}

	public OrdenServicioDetServicio removeOrdenServicioDetServicio(OrdenServicioDetServicio ordenServicioDetServicio) {
		getOrdenServicioDetServicios().remove(ordenServicioDetServicio);
		ordenServicioDetServicio.setServicio(null);

		return ordenServicioDetServicio;
	}

	public List<ServicioFuncionario> getServicioFuncionarios() {
		return this.servicioFuncionarios;
	}

	public void setServicioFuncionarios(List<ServicioFuncionario> servicioFuncionarios) {
		this.servicioFuncionarios = servicioFuncionarios;
	}

	public ServicioFuncionario addServicioFuncionario(ServicioFuncionario servicioFuncionario) {
		getServicioFuncionarios().add(servicioFuncionario);
		servicioFuncionario.setServicio(this);

		return servicioFuncionario;
	}

	public ServicioFuncionario removeServicioFuncionario(ServicioFuncionario servicioFuncionario) {
		getServicioFuncionarios().remove(servicioFuncionario);
		servicioFuncionario.setServicio(null);

		return servicioFuncionario;
	}

	public List<VentaDetServicio> getVentaDetServicios() {
		return this.ventaDetServicios;
	}

	public void setVentaDetServicios(List<VentaDetServicio> ventaDetServicios) {
		this.ventaDetServicios = ventaDetServicios;
	}

	public VentaDetServicio addVentaDetServicio(VentaDetServicio ventaDetServicio) {
		getVentaDetServicios().add(ventaDetServicio);
		ventaDetServicio.setServicio(this);

		return ventaDetServicio;
	}

	public VentaDetServicio removeVentaDetServicio(VentaDetServicio ventaDetServicio) {
		getVentaDetServicios().remove(ventaDetServicio);
		ventaDetServicio.setServicio(null);

		return ventaDetServicio;
	}

}