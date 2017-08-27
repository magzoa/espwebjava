package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;
<<<<<<< HEAD
=======
import py.edu.fpune.posgrado.annotation.Transient;
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
import py.edu.fpune.posgrado.util.ManejadorFecha;


/**
 * The persistent class for the funcionario database table.
 * Entidad de funcionario
 */
@Entity
@Table(name="funcionario")
//@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer id;

	@Column(name="barrio")
	private String barrio;
	
	@Column(name="ciudad")
	private String ciudad;

	@Column(name="direccion")
	private String direccion;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento", type=DataType.DATE)
	private Date fechaNacimiento;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="numero")
	private Integer numero;

	@Column(name="ruc")
	private String ruc;

	//bi-directional many-to-one association to ServicioFuncionario
	//@OneToMany(mappedBy="funcionario")
<<<<<<< HEAD
=======
	@Transient
	@Column(name="servicio_funcionario",classListName="ServicioFuncionario",type=DataType.LIST)
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
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
		if(this.fechaNacimiento!=null){
			return ManejadorFecha.dateUtilAdateSQL(this.fechaNacimiento);
		}
		return null;
		
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