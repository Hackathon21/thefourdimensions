package com.example.backend.services;

import com.example.backend.model.Store;
import com.example.backend.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repo;
    @Autowired
    private HttpServletRequest request;

    public void addStore(Store store){
        try{
            repo.save(store);
        }catch (Exception e){
            throw e;
        }
    }

    public void addFile(UUID id, MultipartFile file){
        try {
            Store store = repo.getById(id);
            store.setFilename(file.getOriginalFilename());
            String uploadDir = "/uploads/";
            String path = request.getServletContext().getRealPath(uploadDir);
            file.transferTo(new File(path));
        }catch (Exception e){
        }
    }
}
