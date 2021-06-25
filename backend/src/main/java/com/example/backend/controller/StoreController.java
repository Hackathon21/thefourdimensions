package com.example.backend.controller;

import com.example.backend.model.Store;
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
    HttpServletRequest request;

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
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable String id){
        try {
            UUID uuid = UtilFunctions.getUUID(id);
            service.addFile(uuid, file);
            return ResponseEntity.ok("File Uploaded!");
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/downloadFile/{id}")
    public ResponseEntity<?> downloadFile(@PathVariable String id){
        UUID uuid = UtilFunctions.getUUID(id);
        try{
            Store store = service.getStore(uuid);
            Path path = Paths.get("D:\\uploads\\"+store.getFilename());
            Resource resource = new UrlResource(path.toUri());
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(store.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
                    .body(resource);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
