/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

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
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteCargo;

/**
 *
 * @author user
 */
@RestController
public class CargoController {
	
	@Autowired
	private GerenteCargo gerenteCargo;
	
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
	public @ResponseBody ResponseEntity<ResponseEntity> salvar(@RequestBody Cargo cargo){
 
 
		try {
 
			this.gerenteCargo.addCargo(cargo);
 
			return new ResponseEntity<>(HttpStatus.CREATED);
                        
		}catch(Exception e) {
 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
        
    @RequestMapping(value = "/cargo", method = RequestMethod.GET)
	public ResponseEntity<List<Cargo>> listar() {
		return new ResponseEntity<List<Cargo>>(new ArrayList<Cargo>(
				gerenteCargo.getTodosCargos()), HttpStatus.OK);
	}
     
	@RequestMapping(value = "/cargo/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cargo> buscar(@PathVariable("id") Integer id) {
		Cargo carg = getCargoId(id);
	 
	  if (carg == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Cargo>(carg, HttpStatus.OK);
	}
        
        
	@RequestMapping(value = "/cargo/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCargo(@PathVariable Integer id, @RequestBody Cargo cargo){
        try {
        Cargo cargoCompara = gerenteCargo.getBuscarCargo(id);
        cargoCompara.setNomeCargo(cargo.getNomeCargo());
        cargoCompara.setSalarioCargo(cargo.getSalarioCargo());
        cargoCompara.setGratificacao(cargo.getGratificacao());
        cargoCompara.setValeAlimentacao(cargo.getValeAlimentacao());
        cargoCompara.setValorHoraExtra(cargo.getValorHoraExtra());
        gerenteCargo.updateCargo(cargoCompara);
        return new ResponseEntity("Cargo Atualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Cargo Atualizado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
    
    public Cargo getCargoId(int id){
    
        for(Cargo k : this.gerenteCargo.getTodosCargos()){
            if(k.getId() == id){
                return k;
            }
            
        }
        return null;
    }
}
