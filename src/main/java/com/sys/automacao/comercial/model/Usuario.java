package com.sys.automacao.comercial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYS_USUARIO")
public class Usuario {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private Integer id;
	@Column(name="NOME",nullable=false)
	private String nome;
	@Column(name="USUARIO",nullable=false)
	private String user;
	@Column(name="SENHA",nullable=false)
	private String senha;
	
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}