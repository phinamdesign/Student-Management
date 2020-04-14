package com.vsii.controller;

import com.vsii.model.Conduct;
import com.vsii.service.ConductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/conduct")
public class RankController {

    @Autowired
    private ConductService conductService;

    @GetMapping
    public ResponseEntity<?> listRanks(){
        List<Conduct> conducts = (List<Conduct>) conductService.findAll();
        if (conducts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(conducts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getConductById(@PathVariable Long id){
        Optional<Conduct> conduct = conductService.findById(id);
        if (!conduct.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(conduct, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createConduct(@RequestBody Conduct conduct){
        conductService.save(conduct);
        return new ResponseEntity<>(conduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateConductById(@RequestBody Conduct conduct, @PathVariable Long id){
        Optional<Conduct> conductNew = conductService.findById(id);
        if (!conductNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        conductNew.get().setName(conduct.getName());
        conductService.save(conductNew.get());

        return new ResponseEntity<>(conductNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConductById(@PathVariable Long id){
        Optional<Conduct> conduct = conductService.findById(id);
        if (!conduct.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        conductService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
