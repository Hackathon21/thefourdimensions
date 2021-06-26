package com.example.backend.controller;

import com.example.backend.model.PlasmaDonor;
import com.example.backend.services.PlasmaDonorServices;
import com.example.backend.utils.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/donor")
public class PlasmaDonorController {

    @Autowired
    PlasmaDonorServices services;

    @PostMapping("/createNewDonor")
    public ResponseEntity<?> addDonor(@RequestBody PlasmaDonor donor){
        try{
            services.registerDonor(donor);
            return new ResponseEntity<>(donor,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/deleteDonor/{id}")
    public ResponseEntity<?> deleteDonor(@RequestBody String id){
        UUID uuid = UtilFunctions.getUUID(id);
        try{
            services.deleteDonor(uuid);
            return new ResponseEntity<>("Donor Deleted!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllDonors")
    public ResponseEntity<?> getAll(){
        try{
            return new ResponseEntity<>(services.getAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPlasmaDonors/{bloodgroup}/{pincode}")
    public ResponseEntity<?> getByPincode(@PathVariable String pincode,@PathVariable String bloodgroup){
        try{
            return new ResponseEntity<>(services.getDonorsByPincodeAndBloodGroup(pincode,bloodgroup),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
