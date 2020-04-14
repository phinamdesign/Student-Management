package com.vsii.controller;

import com.vsii.model.Department;
import com.vsii.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> listDepartments(){
        List<Department> departments = (List<Department>) departmentService.findAll();
        if (departments.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartmentById(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        if (!department.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@RequestBody Department department){
        departmentService.save(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartmentById(@RequestBody Department department, @PathVariable Long id){
        Optional<Department> departmentNew = departmentService.findById(id);
        if (!departmentNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentNew.get().setName(department.getName());
        departmentService.save(departmentNew.get());

        return new ResponseEntity<>(departmentNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Long id){
        Optional<Department> department = departmentService.findById(id);
        if (!department.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departmentService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
