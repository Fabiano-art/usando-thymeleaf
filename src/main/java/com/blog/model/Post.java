package com.blog.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="TB_POST")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	
	@Column( nullable = false)
	@NotNull
	private String titulo;
	
	@Column( nullable = false )
	@NotNull
	private String autor;
	
	@Column( nullable = false )
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@NotNull
	private LocalDate data;
	
	@Lob
	@Column( nullable = false )
	@NotNull
	private String texto;
	
	public Post() {}
	
	public Post(Long id, String titulo, String autor, LocalDate data, String texto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.data = data;
		this.texto = texto;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
}
