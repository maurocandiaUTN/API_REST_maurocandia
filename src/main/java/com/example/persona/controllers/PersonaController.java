package com.example.persona.controllers;


import com.example.persona.entities.Persona;
import com.example.persona.servicies.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")//nos permite el ingreso a nuestra API de distintos origenes o clientes
@RequestMapping(path = "api/v1/personas")//url o uri
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

     @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam String filtro){
         try{
             return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro));
         }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
         }
     }

    @GetMapping("/searchPaged")
    public ResponseEntity<?> search(@RequestParam String filtro, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.search(filtro, pageable));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\":\"" + e.getMessage() + "\"}"));
        }
    }

}
