package com.gson.classes;

public class User {
	
	private int id;
	private String Nome;
	
	public User(int id, String nome){
		this.id = id;
		this.Nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	
	
	

}
