package com.pp.repository;

import com.pp.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    Boolean existsByStoreName(String storeName );
}
