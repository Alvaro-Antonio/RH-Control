/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

/**
 *
 * @author user
 */
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


 
@RestController
public class CandidatoController {
        
        @Autowired
 	private List<Candidato> candidatos;
        
        @ApiOperation(
			value="Cadastrar uma nova pessoa", 
			response=Candidato.class, 
			notes="Essa operação salva um novo registro com as informações de pessoa.")
	@ApiResponses(value= {
			@ApiResponse(
					code=200, 
					message="Retorna um Candidato com uma mensagem de sucesso",
					response=Candidato.class
					),
			@ApiResponse(
					code=500, 
					message="Caso tenhamos algum erro vamos retornar um Candidato com a Exception",
					response=Candidato.class
					)
 
	})
	@RequestMapping(value="/candidato", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)	
	public @ResponseBody ResponseEntity<String> salvar(@RequestBody Candidato candidato){
 
 
		try {
 
			this.candidatos.add(candidato);
 
			return new ResponseEntity<>(HttpStatus.CREATED);
                        
		}catch(Exception e) {
 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
		}
	}
      
	@RequestMapping(value = "/candidato", method = RequestMethod.GET)
	public ResponseEntity<List<Candidato>> listar() {
		return new ResponseEntity<List<Candidato>>(new ArrayList<Candidato>(
				candidatos), HttpStatus.OK);
	}
     
	
	@RequestMapping(value = "/candidato/{id}", method = RequestMethod.GET)
	public ResponseEntity<Candidato> buscar(@PathVariable("id") Integer id) {
		Candidato candida = getCandidatoId(id);
	 
	  if (candidatos == null) {
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	  }
	 
	  return new ResponseEntity<Candidato>(candida, HttpStatus.OK);
	}
       /*@RequestMapping(value="/candidato/{id}", method = RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody String atualizar(@PathVariable Integer id,@RequestBody Candidato candi){
 
		try {
			for(Candidato k: this.candidatos) {
                            if(k.getId() == id){
                                k.setIdade(candi.getIdade());
                                k.getNome(candi.getNome());
                            }
                        }
			return "Registro atualizado com sucesso!";
 
		}catch(Exception e) {
 
			return e.getMessage();
		}
	}*/
        @PutMapping("/candidato/{id}")
        public ResponseEntity<Object> updateStudent(@RequestBody Candidato cand, @PathVariable Integer id) {

                Candidato candida = getCandidatoId(id);

                if (candida == null) {
                    return ResponseEntity.notFound().build();
                }

                cand.setId(id);

                setCandidato(cand);

                return ResponseEntity.noContent().build();
}

      
	/*@RequestMapping(value = "/")
	public String mostra() {
		 
	  return "<h1>Oiaaaa</h1>";
	}*/
        public Candidato getCandidatoId(int id){
            
            for(Candidato k : candidatos){
                if(k.getId() == id){
                    return k;
                }
            }
            return null;
        }
        public void setCandidato(Candidato candid){
            for (Candidato k : this.candidatos){
                if(k.getId() == candid.getId()){
                    k = candid;
                }
            }
        }

}
