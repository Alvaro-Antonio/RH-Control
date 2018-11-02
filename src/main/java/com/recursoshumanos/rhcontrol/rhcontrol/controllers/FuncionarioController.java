package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteFuncionario;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.ResponseModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@RestController
@CrossOrigin(origins= "http://172.17.3.53")
public class FuncionarioController {

    @Autowired
    private GerenteFuncionario gerenteFuncionario;

    
    public FuncionarioController() {
        
    }

   @RequestMapping(value="/funcionario", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody Funcionario funcionario ){
 
		try {
 
			gerenteFuncionario.addFuncionario(funcionario);
 
			return new ResponseModel(1,"Registro salvo com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());			
		}
	}
        @RequestMapping(value = "/funcionario", method = RequestMethod.GET)        
	public ResponseEntity<List<Funcionario>> listar() {
		return new ResponseEntity<List<Funcionario>>(new ArrayList<Funcionario>(
				gerenteFuncionario.getTodosFuncionarios()), HttpStatus.OK);
	}
        
        @RequestMapping(value="/funcionario/{id}", method = RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel excluir(@PathVariable("id") Integer id){
 
		try {
 
			gerenteFuncionario.deletaFuncionario(id);
 
			return new ResponseModel(1, "Funcionario excluido com sucesso!");
 
		}catch(Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

        @RequestMapping(value="/funcionario", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody Funcionario funcionario){
 
		try {
 
			gerenteFuncionario.addFuncionario(funcionario);
 
			return new ResponseModel(1,"Registro atualizado com sucesso!");
 
		}catch(Exception e) {
 
			return new ResponseModel(0,e.getMessage());
		}
	}
    
}
