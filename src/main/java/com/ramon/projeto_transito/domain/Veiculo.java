package com.ramon.projeto_transito.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veiculo implements Serializable{
	
	/**
	 *Ramon Fernandes 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String placa;
	private String modelo;
	private Double divida;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="VEICULO_CATEGORIA",
	           joinColumns = @JoinColumn(name="veiculo_id"),
	           inverseJoinColumns = @JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	public Veiculo() {
	}

	public Veiculo(Integer id, String placa, String modelo, Double divida) {
		super();
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.divida = divida;
	}
	
	

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getDivida() {
		return divida;
	}

	public void setDivida(Double divida) {
		this.divida = divida;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
