/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.controllers;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.Models.Selecao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping(value="/selecao",method = RequestMethod.GET)
    public ResponseEntity<List<Candidato>> listar(){
        ArrayList<Candidato> Candidato;
        
        return new ResponseEntity<List<Candidato>>(new ArrayList<Candidato>(selecao.getCandidatos()), HttpStatus.OK);
    }
    
}
