package com.example.backend.repository;

import com.example.backend.model.PlasmaDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlasmaDonorRepo extends JpaRepository<PlasmaDonor, UUID> {
    List<PlasmaDonor> getPlasmaDonorByPincodeAndBloodGroup(String pincode,String bloodgroup);
}
