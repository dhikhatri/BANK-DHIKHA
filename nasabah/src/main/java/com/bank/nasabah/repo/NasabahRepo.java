/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.repo;

import com.bank.nasabah.entities.Nasabah;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fujitsu
 */
@Repository
public interface NasabahRepo extends CrudRepository<Nasabah, Integer>{
    Nasabah findByKtp(@Param("ktp") String ktp);
}
