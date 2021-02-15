/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.nasabah.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fujitsu
 */
@Entity
@Table(name = "nasabah")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nasabah.findAll", query = "SELECT n FROM Nasabah n")
    , @NamedQuery(name = "Nasabah.findById", query = "SELECT n FROM Nasabah n WHERE n.id = :id")
    , @NamedQuery(name = "Nasabah.findByNama", query = "SELECT n FROM Nasabah n WHERE n.nama = :nama")
    , @NamedQuery(name = "Nasabah.findByAlamat", query = "SELECT n FROM Nasabah n WHERE n.alamat = :alamat")
    , @NamedQuery(name = "Nasabah.findByTempatlahir", query = "SELECT n FROM Nasabah n WHERE n.tempatlahir = :tempatlahir")
    , @NamedQuery(name = "Nasabah.findByTanggallahir", query = "SELECT n FROM Nasabah n WHERE n.tanggallahir = :tanggallahir")
    , @NamedQuery(name = "Nasabah.findByKtp", query = "SELECT n FROM Nasabah n WHERE n.ktp = :ktp")
    , @NamedQuery(name = "Nasabah.findByHp", query = "SELECT n FROM Nasabah n WHERE n.hp = :hp")})
public class Nasabah implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 200)
    @Column(name = "alamat")
    private String alamat;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tempatlahir")
    private String tempatlahir;
    @Basic(optional = false)
    //@NotNull
    @Column(name = "tanggallahir")
    @Temporal(TemporalType.DATE)
    private Date tanggallahir;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ktp")
    private String ktp;
    @Basic(optional = false)
    //@NotNull
    @Size(min = 1, max = 20)
    @Column(name = "hp")
    private String hp;

    public Nasabah() {
    }

    public Nasabah(Integer id) {
        this.id = id;
    }

    public Nasabah(Integer id, String nama, String alamat, String tempatlahir, Date tanggallahir, String ktp, String hp) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.tempatlahir = tempatlahir;
        this.tanggallahir = tanggallahir;
        this.ktp = ktp;
        this.hp = hp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
    }

    public Date getTanggallahir() {
        return tanggallahir;
    }

    public void setTanggallahir(Date tanggallahir) {
        this.tanggallahir = tanggallahir;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nasabah)) {
            return false;
        }
        Nasabah other = (Nasabah) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bank.nasabah.entities.Nasabah[ id=" + id + " ]";
    }
    
}
