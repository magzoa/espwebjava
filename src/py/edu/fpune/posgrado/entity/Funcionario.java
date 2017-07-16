package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.Id;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
//@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String barrio;

	private String ciudad;

	private String direccion;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private String nombre;

	private Integer numero;

	private String ruc;

	//bi-directional many-to-one association to ServicioFuncionario
	//@OneToMany(mappedBy="funcionario")
	private List<ServicioFuncionario> servicioFuncionarios;

	public Funcionario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBarrio() {
		return this.barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRuc() {
		return this.ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public List<ServicioFuncionario> getServicioFuncionarios() {
		return this.servicioFuncionarios;
	}

	public void setServicioFuncionarios(List<ServicioFuncionario> servicioFuncionarios) {
		this.servicioFuncionarios = servicioFuncionarios;
	}

	public ServicioFuncionario addServicioFuncionario(ServicioFuncionario servicioFuncionario) {
		getServicioFuncionarios().add(servicioFuncionario);
		servicioFuncionario.setFuncionario(this);

		return servicioFuncionario;
	}

	public ServicioFuncionario removeServicioFuncionario(ServicioFuncionario servicioFuncionario) {
		getServicioFuncionarios().remove(servicioFuncionario);
		servicioFuncionario.setFuncionario(null);

		return servicioFuncionario;
	}

}