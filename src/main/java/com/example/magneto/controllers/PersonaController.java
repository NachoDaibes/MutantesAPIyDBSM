package com.example.magneto.controllers;

import com.example.magneto.DTO.DNA_DTO;
import com.example.magneto.entities.Persona;
import com.example.magneto.matrices.Matriz;
import com.example.magneto.services.PersonaServiceImpl;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v2/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

    private Gson gson = new Gson();

    @PostMapping("/mutant/")
    public ResponseEntity<?> isMutant(@RequestBody Object dna){

        try {
            Matriz matriz = new Matriz();

            Persona entity = new Persona();
            entity.setNombre("James");
            entity.setApellido("Howlett");

            //se recibe el Json de postman y se convierte en una clase trabajable para java
            DNA_DTO adn = gson.fromJson(dna.toString(), DNA_DTO.class);
            entity.setDna(adn.getDna());

            entity.setMutant(matriz.isMutant(entity.getDna()));

            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
