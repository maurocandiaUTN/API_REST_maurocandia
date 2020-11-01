package com.example.persona.controllers;

import com.example.persona.entities.Base;
import com.example.persona.entities.Persona;
import com.example.persona.servicies.BaseService;
import com.example.persona.servicies.BaseServiceImpl;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

public abstract class BaseControllerImpl<E extends Base, S extends BaseServiceImpl<E,Long>> implements BaseController<E, Long> {

    @Autowired
    protected S servicio;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll());//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }

    @GetMapping("/paged")
    public ResponseEntity<?> getAll(Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findAll(pageable));//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id){//una variable dentro del path o url
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findById(id));//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }
    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody E entity){

        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){

        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));//contiene el status d la respuesta si salio bien o mal
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");//mensaje bdy formato Json

        }
    }
}
