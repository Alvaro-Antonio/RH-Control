package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteCargoService;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.GerenteFuncionario;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author user
 */
@RestController
public class FuncionarioController {

    @Autowired
    private GerenteFuncionario gerenteFuncionario;

    
    public FuncionarioController() {
        
    }

    @ApiOperation(value = "Cadastrar um novo Cargo", response = Cargo.class, notes = "Essa operação salva um novo registro com as informações do Cargo.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Retorna um Cargo com uma mensagem de sucesso", response = Cargo.class)
        ,
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um Cargo com a Exception", response = Cargo.class)
        ,
			@ApiResponse(code = 201, message = "Cargo foi criado", response = Cargo.class)

    })
    /*@RequestMapping(value = "/funcionario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody ResponseEntity<String> salvar( ) {

        try {
            for (Candidato k : selecao.getCandidatos() ){
                
            }
            
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
   /* @RequestMapping(value = "/funcionario/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cargo> buscar(@PathVariable("id") Integer id) {
        Cargo carg = getCargoId(id);

        if (carg == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Cargo>(carg, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/funcionario/{id}/cargo/", method = RequestMethod.PUT)
    public ResponseEntity updateCargo(@PathVariable Integer idFunc,@RequestBody String cargo) {
        try {
            //Funcionario func = gerenteFuncionario.buscarFuncionario(idFunc);
            /*
			 * Cargo cargo = func.setNomeCargo(cargo.getNomeCargo());
			 * func.setSalarioCargo(cargo.getSalarioCargo());
			 * func.setGratificacao(cargo.getGratificacao());
			 * func.setValeAlimentacao(cargo.getValeAlimentacao());
			 * func.setValorHoraExtra(cargo.getValorHoraExtra());
			 * gerenteFuncionario.updateCargo(func);
             */
            return new ResponseEntity("Cargo Atualizado", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Cargo Atualizado",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
