package com.example.backend.controller;

import com.example.backend.model.Store;
import com.example.backend.services.StoreService;
import com.example.backend.utils.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService service;

    @PostMapping("/createStore")
    public ResponseEntity<?> createNewStore(@RequestBody Store store){
        try{
            service.addStore(store);
            return new ResponseEntity<>(store,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/uploadFile/{id}")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file, @PathVariable String id){
        try {
            UUID uuid = UtilFunctions.getUUID(id);
            service.addFile(uuid, file);
            return ResponseEntity.ok("File Uploaded!");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
