/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mcluci
 */
@Service
public class DimensionServImpl implements DimensionService {

    @Autowired
    DimensionRepository dimensionRepository;
    @Override
    public List<Dimension> getAllDimension() {
        return dimensionRepository.findAll();
    }
    
       @Override
    public Dimension addDimension(Dimension dimension) {
        return dimensionRepository.save(dimension);
    }

  
    @Override
    public Dimension upDateDimension(Dimension dimension) {
        return dimensionRepository.saveAndFlush(dimension);
    }

    @Override
    public Optional<Dimension> getDimension(long id) {
        return dimensionRepository.findById(id);
    }

    @Override
    public void deleteDimension(long id) {
        dimensionRepository.deleteById(id);
    }
    
   
    
}
