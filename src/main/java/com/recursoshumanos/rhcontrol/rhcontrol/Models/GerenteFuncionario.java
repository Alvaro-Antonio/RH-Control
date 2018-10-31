package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RecurosHumanos.ufpb.RecurosHumanos.Exceptions.FuncionarioNaoExisteException;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.FuncionarioRepository;

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
public class GerenteFuncionario {
        
    @Autowired
    private FuncionarioRepository funcionarioRepository;
    
   
	public GerenteFuncionario(){
		
	}
	public void addFuncionario(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}

	public List<Funcionario> getTodosFuncionarios() {
		return funcionarioRepository.findAll();
	}
        public Funcionario getFuncionario(Integer id){
            Optional<Funcionario> obj = funcionarioRepository.findById(id);
            return obj.orElse(null);
        }
        public void deletaFuncionario(Integer id){
            funcionarioRepository.deleteById(id);
        }
       
	
}