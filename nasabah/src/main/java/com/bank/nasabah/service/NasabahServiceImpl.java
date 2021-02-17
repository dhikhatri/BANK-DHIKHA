/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.service;

import com.bank.nasabah.entities.Nasabah;
import com.bank.nasabah.repo.NasabahRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fujitsu
 */
@Service
public class NasabahServiceImpl implements NasabahService{

    @Autowired
    private NasabahRepo nasabahrepo;

    @Override
    public Iterable<Nasabah> findAll() {
       return nasabahrepo.findAll();
    }

    @Override
    public Nasabah saveNasabah(Nasabah nasabah) {
        return nasabahrepo.save(nasabah);
    }
    
    @Override
    public Optional<Nasabah> findbyId(Integer id) {
        return nasabahrepo.findById(id);
    }
    
    @Override
    public Optional<Nasabah>findByKtp(String ktp) {
        return nasabahrepo.findByKtp(ktp);
    }
    
    @Override
    public void deleteById(Integer id) {
        nasabahrepo.deleteById(id);
    }
    
}
