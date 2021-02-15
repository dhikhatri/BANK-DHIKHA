/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.controller;

import com.bank.nasabah.entities.Nasabah;
import com.bank.nasabah.service.NasabahService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fujitsu
 */
@RestController
@RequestMapping("/api/")
public class NasabahController {
    
    @Autowired
    private NasabahService nasabahservice;
    
    @GetMapping ("/nasabah")
    public Iterable<Nasabah> getAllNasabah(){
        return nasabahservice.findAll();
    }
    
    @PostMapping("/nasabah") 
    public Nasabah saveNasabah(@RequestBody Nasabah nasabah){
       return nasabahservice.saveNasabah(nasabah);   
    }
    
    @GetMapping("/nasabah/{id}") 
    public Optional<Nasabah> findbyId(@PathVariable Integer id){
        return nasabahservice.findbyId(id);
    }
    
    @GetMapping("/nasabah/ktp/{ktp}")
    public Nasabah findByKtp(@PathVariable String ktp) {
        return nasabahservice.findByKtp(ktp);
    }
    
    @PutMapping("/nasabah/{id}") 
    public ResponseEntity<Nasabah> updateNasabah(@PathVariable Integer id, @RequestBody Nasabah nasabahDetails){
        Nasabah nasabah = nasabahservice.findbyId(id).orElse(null);    
        
        nasabah.setNama(nasabahDetails.getNama());
        nasabah.setAlamat(nasabahDetails.getAlamat());
        nasabah.setTempatlahir(nasabahDetails.getTempatlahir());
        nasabah.setTanggallahir(nasabahDetails.getTanggallahir());
        nasabah.setKtp(nasabahDetails.getKtp());
        nasabah.setHp(nasabahDetails.getHp());
        
        Nasabah updatedNasabah= nasabahservice.saveNasabah(nasabah);
        return ResponseEntity.ok(updatedNasabah);    
    }
    
    @DeleteMapping("/nasabah/{id}")
    public void delete(@PathVariable("id") Integer id) {  
       nasabahservice.deleteById(id);
    }
}
