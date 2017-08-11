package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer id;

	@Column(name="barrio",type=DataType.STRING,length=255)
	private String barrio;

	@Column(name="ciudad",type=DataType.STRING,length=255)
	private String ciudad;

	@Column(name="direccion",type=DataType.STRING,length=255)
	private String direccion;

	//@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento",type=DataType.DATE)
	private Date fechaNacimiento;

	@Column(name="nombre",type=DataType.STRING,length=255)
	private String nombre;

	@Column(name="numero",type=DataType.INTEGER)
	private Integer numero;

	@Column(name="ruc",type=DataType.STRING,length=15)
	private String ruc;

	//bi-directional many-to-one association to Vehiculo
	//@OneToMany(mappedBy="cliente")
	private List<Vehiculo> vehiculos;

	public Cliente() {
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

	public List<Vehiculo> getVehiculos() {
		return this.vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Vehiculo addVehiculo(Vehiculo vehiculo) {
		getVehiculos().add(vehiculo);
		vehiculo.setCliente(this);

		return vehiculo;
	}

	public Vehiculo removeVehiculo(Vehiculo vehiculo) {
		getVehiculos().remove(vehiculo);
		vehiculo.setCliente(null);

		return vehiculo;
	}

}