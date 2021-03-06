/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.ResponseModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteCargoService;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author user
 */
@RestController
@CrossOrigin(origins= "http://172.17.4.50")
public class CargoController {
	
	@Autowired
	private GerenteCargoService gerenteCargo;
	
        public CargoController(){
    }
    
    @ApiOperation(
			value="Cadastrar um novo Cargo", 
			response=Cargo.class, 
			notes="Essa operação salva um novo registro com as informações do Cargo.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um Cargo com uma mensagem de sucesso",
					response=Cargo.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um Cargo com a Exception",
					response=Cargo.class
					),
            @ApiResponse(
					code=201, 
					message="Cargo foi criado",
					response=Cargo.class
					)
 
	})
	@RequestMapping(value="/cargo", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Cargo cargo){
 
		try {
 
			this.gerenteCargo.save(cargo);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
        
        @RequestMapping(value = "/cargo", method = RequestMethod.GET)
        
	public ResponseEntity<List<Cargo>> listar() {
		return new ResponseEntity<List<Cargo>>(new ArrayList<Cargo>(
				gerenteCargo.findAll()), HttpStatus.OK);
	}
     
	@RequestMapping(value = "/cargo/{id}", method = RequestMethod.GET)       
	public ResponseEntity<Cargo> buscar(@PathVariable("id") Integer id) {
		Cargo carg = gerenteCargo.getBuscarCargo(id);
	  if (carg == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Cargo>(carg, HttpStatus.OK);
	}
        
        
        @RequestMapping(value="/cargo", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Cargo cargo){
 
		try {
 
			gerenteCargo.save(cargo);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
        
        @RequestMapping(value="/cargo/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
 
			gerenteCargo.remove(id);
 
			return new ResponseModel(1, "Cargo excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
        
    
    
    
  }
