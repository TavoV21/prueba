package com.ecodeup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Libros")
public class Libro {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idlibro;
	@Column
	private String libro;
	@Column
	private String autor;
	@Column
	private double paginas;
	@Column
	private double precio;
	
	
	

	public Long getIdlibro() {
		return idlibro;
	}

	public void setIdlibro(Long idlibro) {
		this.idlibro = idlibro;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public double getPaginas() {
		return paginas;
	}

	public void setPaginas(double paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		return "Libro [idlibro=" + idlibro + ",libro=" + libro + " ,autor=" + autor + ",paginas="+ paginas +",precio=" + precio + "]";
	}
	
}