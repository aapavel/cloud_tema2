/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author mcluci
 */
public interface DimensionService {
    List<Dimension> getAllDimension();
    
    Dimension addDimension(Dimension dimension);
    
    Dimension upDateDimension(Dimension dimension);
    
   Optional<Dimension> getDimension(long id);
    
    void deleteDimension(long id);
}
