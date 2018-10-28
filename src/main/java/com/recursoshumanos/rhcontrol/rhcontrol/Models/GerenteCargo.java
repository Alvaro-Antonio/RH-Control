package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class GerenteCargo {
        
	private List<Cargo> todosCargos = new ArrayList<>();

	public GerenteCargo() {
		/*Cargo c1 = new Cargo(1, "TEC. iNFORMATICA", 2.500, 120.0, 50, 75.0);
		Cargo c2 = new Cargo(2, "Tec. Manutenção", 2500, 100, 30, 80);
		addCargo(c1);
		addCargo(c2);*/
	}

	public Cargo getBuscarCargo(int id) {
		Cargo cargo = new Cargo();
		for (Cargo c : todosCargos) {
			if (c.getId() == id)
				return c;
		}
		return cargo;
	}

	public void addCargo(Cargo cargo) {
		for (Cargo c : todosCargos) {
			if (c.getNomeCargo().equals(cargo.getNomeCargo()))
				;
		}
		todosCargos.add(cargo);
	}

	public List<Cargo> getTodosCargos() {
		return todosCargos;
	}

	public void updateCargo(Cargo cargo) {
		for (Cargo c : this.todosCargos) {
			if (c.getId() == cargo.getId()) {
				c = cargo;
			}
		}
	}

}
