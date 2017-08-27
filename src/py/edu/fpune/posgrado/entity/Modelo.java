package py.edu.fpune.posgrado.entity;

import py.edu.fpune.posgrado.annotation.Column;
import py.edu.fpune.posgrado.annotation.DataType;
import py.edu.fpune.posgrado.annotation.Entity;
import py.edu.fpune.posgrado.annotation.GeneratedValue;
import py.edu.fpune.posgrado.annotation.Id;
import py.edu.fpune.posgrado.annotation.Table;

@Entity
@Table(name="modelo")
public class Modelo {

	@Id
	@GeneratedValue
<<<<<<< HEAD
	@Column(name="idmodelo",type=DataType.INTEGER,unique=true)
=======
	@Column(name="id",type=DataType.INTEGER,unique=true)
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
	private Integer idModelo;
	
	@Column(name="descripcion",type=DataType.STRING,length=100,orderBy=true)
	private String descripcion;
	
<<<<<<< HEAD
	@Column(name="idmarca",type=DataType.OBJECT)
=======
	@Column(name="id_marca",type=DataType.OBJECT)
>>>>>>> 7edcb28d4b309383704a70c38a5116713d443286
	private Marca marca;
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Modelo [idModelo=" + idModelo + ", descripcion=" + descripcion
				+ ", marca=" + marca + "]";
	}
	
}