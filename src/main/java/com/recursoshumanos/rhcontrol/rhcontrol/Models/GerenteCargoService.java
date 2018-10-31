package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CargoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class GerenteCargoService {
        
        @Autowired
	CargoRepository cargoRepository;

	public GerenteCargoService() {
	}

	public Cargo getBuscarCargo(int id) {
		Optional<Cargo> cargo = cargoRepository.findById(id);
		
		return cargo.orElse(null);
	}
        public List <Cargo> findAll(){
		List <Cargo> obj = cargoRepository.findAll();
		return obj;
	}
        public void remove(Integer id){
                cargoRepository.deleteById(id);
        
	}
        public void save (Cargo cargo){
               cargoRepository.save(cargo);
        }
}