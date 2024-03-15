package com.pp.repository;

import com.pp.models.Store;
import com.pp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Optional<Store> findByStoreName(String storeName);

    List<Store> findByMerchantID(long merchantID);

    Boolean existsByStoreNameAndCountryISOAndActiveStoreTrue(String storeName, String countryISO);

}
