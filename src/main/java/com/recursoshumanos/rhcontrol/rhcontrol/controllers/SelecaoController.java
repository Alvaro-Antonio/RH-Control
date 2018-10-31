/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.SelecaoService;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
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
 * @author alvaro
 */
@RestController
public class SelecaoController {
    @Autowired
    private Selecao selecao;
    @Autowired
    private SelecaoService service;
    
    private final String crossOrigin = "http://10.0.2.46:4200";
	@RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
        @CrossOrigin(origins=crossOrigin)
	public ResponseEntity<Candidato> find(@PathVariable Integer id) {
		Candidato candida = service.find(id);
	 
	  if (candida == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Candidato>(candida, HttpStatus.OK);
	}
        @RequestMapping(value = "/candidato", method = RequestMethod.GET)
        @CrossOrigin(origins="http://10.0.2.46:4200")	
        public ResponseEntity<List<Candidato>> findAll() {
		List<Candidato> candida = service.findAll();
	 
	  if (candida == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<List<Candidato>>(candida, HttpStatus.OK);
	}
        @RequestMapping(value="/candidato", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
        @CrossOrigin(origins="http://10.0.2.46:4200")
	public @ResponseBody ResponseEntity<ResponseEntity> salvar(@RequestBody Candidato candidato){ 
		
            boolean cand = service.create(candidato);
            if (cand){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }      
            else{            
 		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	}
    
}
