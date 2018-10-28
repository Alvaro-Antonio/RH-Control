/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
	public ResponseEntity<Candidato> find(@PathVariable Integer id) {
		Candidato candida = service.find(id);
	 
	  if (candida == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Candidato>(candida, HttpStatus.OK);
	}
    
}
