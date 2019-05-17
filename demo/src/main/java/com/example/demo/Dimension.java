/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mcluci
 */

@Entity
@Table(name = "xls_dimension_item")
class Dimension implements Serializable {
    @Id
    @Column(name = "dimensionid")
    @GeneratedValue(strategy = GenerationType.AUTO )
    private long id;
    
    @Column(name = "description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Dimension(String description) {
        this.description = description;
    }
    
    public Dimension() {
    }

    @Override
    public String toString() {
        return "Dimension{" + "id=" + id + ", description=" + description + '}';
    }
    
    
    
}
