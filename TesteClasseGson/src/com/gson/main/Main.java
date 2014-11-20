package com.gson.main;

import java.util.ArrayList;
import java.util.List;

import com.gson.classes.TrataJson;
import com.gson.classes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String json;
		
		List<User> Usuarios = new ArrayList<User>();
		User u1 = new User(111,"leo");
		User u2 = new User(222,"Raffael");
		
		TrataJson tratarJson = new TrataJson();
		
		Usuarios.add(u1);
		Usuarios.add(u2);
		
		json = tratarJson.ConverterParaJson(Usuarios);
		
		//System.out.println(json);
		
		Usuarios.clear();
		Usuarios = tratarJson.LerJson(json);
		
		for (User usuario : Usuarios) {
			System.out.println(usuario.getNome());
		}
		
		
		
		

	}

}
