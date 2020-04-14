package com.vsii.controller;

import com.vsii.model.Address;
import com.vsii.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<?> listAddress(){
        List<Address> addresses = (List<Address>) addressService.findAll();
        if (addresses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id){
        Optional<Address> address = addressService.findById(id);
        if (!address.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address){
        addressService.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddressById(@RequestBody Address address, @PathVariable Long id){
        Optional<Address> addressNew = addressService.findById(id);
        if (!addressNew.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressNew.get().setName(address.getName());
        addressService.save(addressNew.get());

        return new ResponseEntity<>(addressNew, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddressById(@PathVariable Long id){
        Optional<Address> address = addressService.findById(id);
        if (!address.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
