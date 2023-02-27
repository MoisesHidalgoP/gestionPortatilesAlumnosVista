package gestionPortatilesAlumnosVista.aplicacion.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="portatil", schema="dlk_gestion")
public class portatil {
	
	//Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPortail" , unique=true, nullable=false)
	private int idPortatil;
	@Column(name="md_uuid")
	private String md_uuid;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	
	//Getters y Setters
	public int getIdPortatil() {
		return idPortatil;
	}
	public void setIdPortatil(int idPortatil) {
		this.idPortatil = idPortatil;
	}
	public String getMd_uuid() {
		return md_uuid;
	}
	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	
	public portatil(Integer idPortatil, String marca, String modelo) {
		this.idPortatil = idPortatil;
		this.marca = marca;
		this.modelo = modelo;
	}
	//Constructores
	public portatil() {}
	
	public portatil(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
	//toString
	@Override
	public String toString() {
		return " Portatil idPortatil: " + idPortatil + " Mduuid: " + md_uuid + " Marca: " + marca + " Modelo: " + modelo
				;
	}

}
