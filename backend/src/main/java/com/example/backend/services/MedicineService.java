package com.example.backend.services;

import com.example.backend.model.Medicine;
import com.example.backend.model.Store;
import com.example.backend.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MedicineService {

    @Autowired
    private MedicineRepository repository;
    @Autowired
    private StoreService service;

    public List<Medicine> getMedicines(String name,String pincode){
        List<Store> available  = service.getByPincode(pincode);
        List<Medicine> medicines = new ArrayList<>();
        for(Store s:available){
            List<Medicine> m = s.getMedicineList();
            for(Medicine k:m){
                if(k.getName().equals(name)){
                    medicines.add(k);
                }
            }
        }
        return medicines;
    }

    public List<Medicine> getAllMedicines(){
        return repository.findAll();
    }

    public Medicine getByName(String name){
        return repository.getMedicineByName(name);
    }

    public void updateMedicine(Medicine medicine){
        try{
            repository.save(medicine);
        }catch(Exception e){
            throw e;
        }
    }
}
