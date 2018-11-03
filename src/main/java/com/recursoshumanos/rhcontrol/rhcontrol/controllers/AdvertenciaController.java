/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Advertencia;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.ResponseModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author naian
 */
@RestController
@CrossOrigin(origins= "http://172.17.4.50")
public class AdvertenciaController {
    
    @Autowired
    private Advertencia adverter;
    
     public AdvertenciaController(){
    }
    @RequestMapping(value="/advertencia", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Advertencia advertencia ){
 
		try {
 
			adverter.save(advertencia);
 
			return new ResponseModel(1,"Advertencia salva com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
    
    @RequestMapping(value = "/Advertencia", method = RequestMethod.GET)
        
	public ResponseEntity<List<Advertencia>> listar() {
		return new ResponseEntity<List<Advertencia>>(new ArrayList<Advertencia>(
				adverter.findAll()), HttpStatus.OK);
	}
        
    @RequestMapping(value = "/Advertencia/{id}", method = RequestMethod.GET)
       
	public ResponseEntity<Advertencia> buscar(@PathVariable("id") Integer id) {
		Advertencia advertencia = adverter.getBuscarAdvertencia(id);
	  if (advertencia == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Advertencia>(advertencia, HttpStatus.OK);
	}
        
    @RequestMapping(value="/Advertencia", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Advertencia advertencia){
 
		try {
 
			adverter.save(advertencia);		
 
			return new ResponseModel(1,"Advertencia atualizada com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
        
    @RequestMapping(value="/Advertencia/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
 
			adverter.remove(id);
 
                   			return new ResponseModel(1, "Advertencia excluida com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
}
