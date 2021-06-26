package com.example.backend.services;

import com.example.backend.DTO.MedicineUpload;
import com.example.backend.model.Medicine;
import com.example.backend.model.Store;
import com.example.backend.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repo;
    @Autowired
    private MedicineService medicineService;

    public void addStore(Store store){
        try{
            repo.save(store);
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

    public List<Store> getByPincode(String pincode){
        return repo.getStoreByPincode(pincode);
    }

    public Store getByPhone(String phone){
        try{
            return repo.getStoreByPhoneNumber(phone);
        }catch (Exception e){
            throw e;
        }
    }
}
