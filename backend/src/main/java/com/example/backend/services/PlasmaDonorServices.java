package com.example.backend.services;

import com.example.backend.model.PlasmaDonor;
import com.example.backend.repository.PlasmaDonorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlasmaDonorServices {
    @Autowired
    PlasmaDonorRepo repo;

    public void registerDonor(PlasmaDonor donor){
        try {
            repo.save(donor);
        }catch (Exception e){
            throw e;
        }
    }

    public void disableDonor(UUID id){
        try {
            PlasmaDonor donor = repo.getById(id);
            donor.setEnabled(false);
        }catch (Exception e){
            throw e;
        }
    }

    public void deleteDonor(UUID id){
        try{
            PlasmaDonor donor = repo.getById(id);
            repo.delete(donor);
        }catch (Exception e){
            throw e;
        }
    }
}
