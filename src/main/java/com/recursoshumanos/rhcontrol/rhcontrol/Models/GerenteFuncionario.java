package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import RecurosHumanos.ufpb.RecurosHumanos.Exceptions.FuncionarioNaoExisteException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class GerenteFuncionario {
        
    private List<Funcionario> todosFuncionarios;
    
    @Autowired
    private GerenteCargo gerenteCargo;

	public GerenteFuncionario(){
		todosFuncionarios = new ArrayList<>();
	}
	public void addFuncionario(Funcionario funcionario) {
		todosFuncionarios.add(funcionario);
	}

	public List<Funcionario> getTodosFuncionarios() {
		return todosFuncionarios;
	}

	public void setTodosFuncionarios(List<Funcionario> todosFuncionarios) {
		this.todosFuncionarios = todosFuncionarios;
	}
	
	public Funcionario buscarFuncionario(Integer id)throws FuncionarioNaoExisteException{
		for( Funcionario c : todosFuncionarios) {
			if(c.getId() == id){
                                return c;
                        }
                }
		throw new FuncionarioNaoExisteException("Funionario não encontrado!");
	
        }
	public void promoverFuncionario(int id,Cargo cargo) throws FuncionarioNaoExisteException{
		for(Funcionario k : todosFuncionarios) {
			if(k.getId() == id) k.setCargo(cargo);
		}
		throw new FuncionarioNaoExisteException("Esse funcionário Não pode ser Encontrado");
	}
	
	/*public void desligarFuncionario(String nome) throws FuncionarioNaoExisteException{
		for(Funcionario k : todosFuncionarios) {
			if(k.getNome().equals(nome)) todosFuncionarios.remove(k);
		}
		throw new FuncionarioNaoExisteException("Esse funcionário Não pode ser Encontrado");
	}*/
	
}