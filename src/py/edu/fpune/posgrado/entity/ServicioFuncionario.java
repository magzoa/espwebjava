package py.edu.fpune.posgrado.entity;

import java.io.Serializable;
import javax.persistence.*;

<<<<<<< HEAD
=======
import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;


/**
 * The persistent class for the servicio_funcionario database table.
 * 
 */
@Entity
@Table(name="servicio_funcionario")
//@NamedQuery(name="ServicioFuncionario.findAll", query="SELECT s FROM ServicioFuncionario s")
public class ServicioFuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
<<<<<<< HEAD
	private Integer id;

=======
	@Column(name="id",type=DataType.INTEGER,unique=true)
	private Integer id;

	@Column(name="descripcion",type=DataType.STRING,length=255)
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
	private String descripcion;

	//bi-directional many-to-one association to Funcionario
	//@ManyToOne
	//@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Servicio
	//@ManyToOne
	//@JoinColumn(name="id_servicio")
	private Servicio servicio;

	public ServicioFuncionario() {
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

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}