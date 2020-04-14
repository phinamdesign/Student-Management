package com.vsii.controller;

import com.vsii.model.ClassR;
import com.vsii.service.ClassRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/class")
public class ClassRController {

    @Autowired
    private ClassRService classRService;

    @GetMapping
    public ResponseEntity<?> listClassRs(){
        List<ClassR> classRS = (List<ClassR>) classRService.findAll();
        if (classRS.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(classRS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassRById(@PathVariable Long id){
        Optional<ClassR> classR = classRService.findById(id);
        if (!classR.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classR, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createClassR(@RequestBody ClassR classR){
        classRService.save(classR);
        return new ResponseEntity<>(classR, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClassRById(@RequestBody ClassR classR, @PathVariable Long id){
        Optional<ClassR> classRNew = classRService.findById(id);
        if (!classRNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classRNew.get().setName(classR.getName());
        classRService.save(classRNew.get());

        return new ResponseEntity<>(classRNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClassRById(@PathVariable Long id){
        Optional<ClassR> classR = classRService.findById(id);
        if (!classR.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classRService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
