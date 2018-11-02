/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.recursoshumanos.rhcontrol.rhcontrol.repositories;

import com.recursoshumanos.rhcontrol.rhcontrol.Models.Advertencia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author naian
 */
public interface AdvertenciaRepository extends JpaRepository<Advertencia,Integer> {
    
      public void save(List<Advertencia> advertencia);
}
