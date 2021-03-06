package com.example.backend.repository;

import com.example.backend.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StoreRepository extends JpaRepository<Store, UUID> {
    List<Store> getStoreByPincode(String pincode);
    Store getStoreByPhoneNumber(String phone);
}
