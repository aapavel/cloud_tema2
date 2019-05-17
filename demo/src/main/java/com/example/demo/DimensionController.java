/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.example.exception.DimensionNotFoundException;
import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.URI;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


/**
 *
 * @author mcluci
 */

@RestController
@RequestMapping(value="/dimension", produces = MediaType.APPLICATION_JSON_VALUE )
public class DimensionController {

    @Autowired
    private DimensionService dimensionService;
    
    @GetMapping(value="/all")
    public List<Dimension> getAllDimension(){
        return dimensionService.getAllDimension();
    }
    
    @PostMapping("/save")
    public ResponseEntity saveDim(@RequestBody Dimension dimension){
         Dimension savedDimension = dimensionService.addDimension(dimension);
        
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/id").buildAndExpand(savedDimension.getId()).toUri();
         
         return ResponseEntity.created(location).build();
         
      
    }
  
    @PutMapping("/update")
    public Dimension upDateDim(@RequestBody Dimension dimension){
         Dimension dimensionUpdate = dimensionService.upDateDimension(dimension);
         if(dimensionUpdate == null)
             throw new DimensionNotFoundException("id - "+ dimension.getId() );
         return dimensionUpdate;
    }
    
    @GetMapping("/by/{id}")
    public Optional<Dimension> getDim(@PathVariable(name ="id")long id ){
         Optional<Dimension> dimensionFound = dimensionService.getDimension(id);
         if(dimensionFound == null)
             throw new DimensionNotFoundException("id - "+id);
         return dimensionFound;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteDim(@PathVariable(name ="id") long id ){
         dimensionService.deleteDimension(id);
    }
    
}
