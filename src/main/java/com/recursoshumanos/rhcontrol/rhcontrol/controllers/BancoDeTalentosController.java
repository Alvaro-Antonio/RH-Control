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

import com.recursoshumanos.rhcontrol.rhcontrol.Models.BancoDeTalentos;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.BancoDeTalentosService;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author naian
 */
@RestController
@CrossOrigin(origins= "http://10.0.3.14")
public class BancoDeTalentosController {
    
    @Autowired
    private BancoDeTalentosService service;
    
     public BancoDeTalentosController(){
    }
    @RequestMapping(value="/bancoDeTalentos", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody BancoDeTalentos talento ){
 
		try {
 
			service.save(talento);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
        
        @RequestMapping(value = "/BancoDeTalentos", method = RequestMethod.GET)
        
	public ResponseEntity<List<BancoDeTalentos>> listar() {
		return new ResponseEntity<List<BancoDeTalentos>>(new ArrayList<BancoDeTalentos>(
				service.findAll()), HttpStatus.OK);
	}
     
	@RequestMapping(value = "/BancoDeTalentos/{id}", method = RequestMethod.GET)
       
	public ResponseEntity<BancoDeTalentos> buscar(@PathVariable("id") Integer id) {
		BancoDeTalentos talentos = service.getBuscarTalento(id);
	  if (talentos == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<BancoDeTalentos>(talentos, HttpStatus.OK);
	}
        
        
        @RequestMapping(value="/BancoDeTalentos", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody BancoDeTalentos talentos){
 
		try {
 
			service.save(talentos);		
 
			return new ResponseModel(1,"talento atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
        
        @RequestMapping(value="/BancoDeTalentos/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
 
			service.remove(id);
 
                   			return new ResponseModel(1, "Talento excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}


