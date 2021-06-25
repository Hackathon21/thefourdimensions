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

    public void addFile(UUID id, MultipartFile file)throws Exception{
        try {
            Store store = repo.getById(id);
            store.setFilename(file.getOriginalFilename());
            store.setContentType(file.getContentType());
            updateStore(store);
            String uploadDir = "D:\\uploads\\";
            String path = uploadDir;
            file.transferTo(new File(path+file.getOriginalFilename()));
        }catch (Exception e){
            throw e;
        }
    }

    public void updateStore(Store store){
        try{
            repo.save(store);
        }catch (Exception e){
            throw e;
        }
    }

    public Store getStore(UUID id){
        try{
            Store store = repo.getById(id);
            return store;
        }catch (Exception e){
            throw e;
        }
    }
}
