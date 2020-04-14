package com.vsii.controller;

import com.vsii.model.Student;
import com.vsii.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> listStudents(){
        List<Student> students = (List<Student>) studentService.findAll();
        if (students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUserById(@RequestBody Student student, @PathVariable Long id){
        Optional<Student> studentNew = studentService.findById(id);
        if (!studentNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        studentNew.get().setName(student.getName());
        studentNew.get().setAge(student.getAge());
        studentService.save(studentNew.get());

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        Optional<Student> student = studentService.findById(id);
        if (!student.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
       studentService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
