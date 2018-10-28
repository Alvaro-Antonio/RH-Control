/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.repositories;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Cargo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alvaro
 */
@Repository
public interface CargoRepository extends JpaRepository<Cargo,Integer>{

    public void save(List<Cargo> asList);
    
}
