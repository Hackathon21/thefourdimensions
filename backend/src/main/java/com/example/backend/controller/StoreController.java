package com.example.backend.controller;

import com.example.backend.DTO.MedicineUpload;
import com.example.backend.model.Medicine;
import com.example.backend.model.Store;
import com.example.backend.services.MedicineService;
import com.example.backend.services.StoreService;
import com.example.backend.utils.UtilFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    StoreService service;
    @Autowired
    MedicineService service1;

    @PostMapping("/createStore")
    public ResponseEntity<?> createNewStore(@RequestBody Store store){
        try{
            if(service.getByPhone(store.getPhoneNumber())!=null)throw new EntityExistsException();
            service.addStore(store);
            return new ResponseEntity<>(store,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/addMedicine/{phone}")
    public ResponseEntity<?> addMedicine(@PathVariable String phone,@RequestBody MedicineUpload medicine){
        try{
            Store store = service.getByPhone(phone);
            Medicine medicine1 = service1.getByName(medicine.getName());
            if(medicine1==null){
                medicine1 = new Medicine();
                medicine1.addStore(store);
                medicine1.setStoreName(store.getName());
                medicine1.setPrice(medicine.getPrice());
                medicine1.setStock(medicine.getStock());
                medicine1.setName(medicine.getName());
            }else{
                medicine1.setStock(medicine1.getStock()+medicine.getStock());
                medicine1.setPrice(medicine1.getPrice());
            }
            service.updateStore(store);
            return new ResponseEntity<>("Successfully updated!",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
//if(medicine1==null){
//                medicine1 = new Medicine();
//                medicine1.setName(medicine.getName());
//                medicine1.setStock(medicine.getStock());
//                medicine1.setPrice(medicine.getPrice());
//                medicine1.setStore(store);
//                medicine1.setStoreName(store.getName());
//                store.addMedicine(medicine1);
//            }else{
//                medicine1.setStock(medicine.getStock()+medicine1.getStock());
//                medicine1.setPrice(medicine.getPrice());
//                service1.updateMedicine(medicine1);
//            }
//            service.updateStore(store);