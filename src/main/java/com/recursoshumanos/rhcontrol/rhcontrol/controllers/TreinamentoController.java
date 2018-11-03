/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.SelecaoService;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Treinamento;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Funcionario;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteFuncionario;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.ResponseModel;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.TreinamentoService;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.SelecaoRepository;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import javassist.compiler.ast.StringL;
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
@CrossOrigin(origins= "http://172.17.4.50")
public class TreinamentoController {
    @Autowired
    private Selecao selecao;
    @Autowired
    private TreinamentoService service;
        
    	@RequestMapping(value = "/treinamento/{id}", method = RequestMethod.GET)        
	public ResponseEntity<Treinamento> find(@PathVariable Integer id) {
		Treinamento candida = service.find(id);
	 
	  if (candida == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Treinamento>(candida, HttpStatus.OK);
	}
        @RequestMapping(value = "/treinamento", method = RequestMethod.GET)
        
        public ResponseEntity<List<Treinamento>> findAll() {
		List<Treinamento> candida = service.findAll();
	 
	  if (candida == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<List<Treinamento>>(candida, HttpStatus.OK);
	}
       @RequestMapping(value="/treinamento", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Treinamento cand){
 
		try {
 
			this.service.create(cand);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
        
       @RequestMapping(value="/treinamento", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Treinamento c){
 
		try {
 
			service.save(c);		
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
        @RequestMapping(value="/treinamento/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
 
			service.remove(id);
 
			return new ResponseModel(1, "Treinamento excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}
        
       
        
}
