/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.service;

import com.bank.nasabah.entities.Nasabah;
import java.util.Optional;

/**
 *
 * @author fujitsu
 */
public interface NasabahService {
    Iterable<Nasabah> findAll();
    
    public Nasabah saveNasabah(Nasabah nasabah);
    
    public Optional<Nasabah>findbyId(Integer id);
    
    public Nasabah findByKtp(String ktp);
    
    void deleteById(Integer id);
}
