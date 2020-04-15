package com.vsii.controller;

import com.vsii.model.School;
import com.vsii.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public ResponseEntity<?> listSchools(){
        List<School> schools = (List<School>) schoolService.findAll();
        if (schools.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(schools, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSchoolById(@PathVariable Long id){
        Optional<School> school = schoolService.findById(id);
        if (!school.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(school, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSchool(@RequestBody School school){
        schoolService.save(school);
        return new ResponseEntity<>(school, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchoolById(@RequestBody School school, @PathVariable Long id){
        Optional<School> schoolNew = schoolService.findById(id);
        if (!schoolNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        schoolNew.get().setName(school.getName());
        schoolService.save(schoolNew.get());

        return new ResponseEntity<>(schoolNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchoolById(@PathVariable Long id){
        Optional<School> school = schoolService.findById(id);
        if (!school.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        schoolService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
