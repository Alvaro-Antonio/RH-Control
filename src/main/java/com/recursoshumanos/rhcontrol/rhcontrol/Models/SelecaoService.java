/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.Models;

/**
 *
 * @author alvaro
 */

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import com.recursoshumanos.rhcontrol.rhcontrol.repositories.CandidatoRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelecaoService {
     @Autowired
        private CandidatoRepository repo;
     
     /*Busca por ID*/
        public Candidato find(Integer id){
            Optional<Candidato> obj = repo.findById(id);
            return obj.orElse(null);
        }
}
