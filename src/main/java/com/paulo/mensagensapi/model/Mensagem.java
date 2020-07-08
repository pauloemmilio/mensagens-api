package com.paulo.mensagensapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Mensagem {

	@JsonProperty(access = Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Texto da mensagem deve ser preenchido")
	@Column(nullable = false)
	private String texto;
	@JsonProperty(access = Access.READ_ONLY)
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	@JsonProperty(access = Access.READ_ONLY)
	@Column(nullable = false)
	private LocalDateTime dataAtualizacao;
	
	public Mensagem () {}

	public Mensagem(String texto) {
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	@Override
	public String toString() {
		return "Mensagem [id=" + id + ", texto=" + texto + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + "]";
	}
	
	@PrePersist
	private void prePersist() {
		LocalDateTime dataAtual = LocalDateTime.now();
		this.dataCriacao = dataAtual;
		this.dataAtualizacao = dataAtual;
	}
	
	@PreUpdate
	private void preUpdate() {
		this.dataAtualizacao = LocalDateTime.now();
	}
}
