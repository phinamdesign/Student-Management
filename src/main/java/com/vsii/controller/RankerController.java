package com.vsii.controller;


import com.vsii.model.ClassR;
import com.vsii.model.Ranker;
import com.vsii.service.RankerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ranker")
public class RankerController {

    @Autowired
    private RankerService rankerService;

    @GetMapping
    public ResponseEntity<?> listRanker(){
        List<Ranker> rankers = (List<Ranker>) rankerService.findAll();
        if (rankers.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(rankers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRankerById(@PathVariable Long id){
        Optional<Ranker> ranker = rankerService.findById(id);
        if (!ranker.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ranker, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createRanker(@RequestBody Ranker ranker){
        rankerService.save(ranker);
        return new ResponseEntity<>(ranker, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRankerById(@RequestBody Ranker ranker, @PathVariable Long id){
        Optional<Ranker> rankerNew = rankerService.findById(id);
        if (!rankerNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rankerNew.get().setName(ranker.getName());
        rankerService.save(rankerNew.get());

        return new ResponseEntity<>(rankerNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRankerById(@PathVariable Long id){
        Optional<Ranker> ranker = rankerService.findById(id);
        if (!ranker.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        rankerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
