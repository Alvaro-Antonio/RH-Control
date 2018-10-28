/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.repositories;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Candidato;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alvaro
 */
@Repository
public interface CandidatoRepository extends JpaRepository<Candidato,Integer>{

    public void save(List<Candidato> asList);
    
}
