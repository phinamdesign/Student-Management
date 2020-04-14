package com.vsii.controller;

import com.vsii.model.ClassR;
import com.vsii.model.Sex;
import com.vsii.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/sex")
public class SexController {

    @Autowired
    private SexService sexService;

    @GetMapping
    public ResponseEntity<?> listSex(){
        List<Sex> sexes = (List<Sex>) sexService.findAll();
        if (sexes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(sexes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSexById(@PathVariable Long id){
        Optional<Sex> sex = sexService.findById(id);
        if (!sex.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(sex, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSex(@RequestBody Sex sex){
        sexService.save(sex);
        return new ResponseEntity<>(sex, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSexById(@RequestBody Sex sex, @PathVariable Long id){
        Optional<Sex> sexNew = sexService.findById(id);
        if (!sexNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sexNew.get().setName(sex.getName());
        sexService.save(sexNew.get());

        return new ResponseEntity<>(sexNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSexById(@PathVariable Long id){
        Optional<Sex> sex = sexService.findById(id);
        if (!sex.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        sexService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
