package com.pp.services;

import com.pp.enums.Roles;
import com.pp.exceptions.InstoreApplicationExceptions;
import com.pp.models.Store;
import com.pp.models.User;
import com.pp.repository.StoreRepository;
import com.pp.repository.UserRepository;
import com.pp.requests.StoreCreateRequest;
import com.pp.response.Response;
import com.pp.response.StoreResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    ModelMapper modelMapper = new ModelMapper();
    public Response<Store> createStore(StoreCreateRequest storeCreateRequest) throws InstoreApplicationExceptions{
        System.out.println(storeCreateRequest);
        if (storeRepository.existsByStoreNameAndCountryISOAndActiveStoreTrue(storeCreateRequest.getStoreName(), storeCreateRequest.getCountryISO()))
            throw new InstoreApplicationExceptions("A Store with the same name already exists");
        User merchant = userRepository.findById(storeCreateRequest.getMerchantID()).orElseThrow(() ->  new InstoreApplicationExceptions("Merchant Does not exist with id " + storeCreateRequest.getMerchantID()));     // check for merchant
        if(!merchant.isActiveUser() ||  merchant.getRole() != Roles.MERCHANT) {
            throw (new InstoreApplicationExceptions("Merchant is not valid ")) ;
        }
        //Store store = Store.builder().storeName(storeCreateRequest.getStoreName()).location(storeCreateRequest.getLocation()).city(storeCreateRequest.getCity()).countryISO(storeCreateRequest.getCountryISO()).activeStore(true).merchantID(storeCreateRequest.getMerchantID()).build();
        Store store = modelMapper.map(storeCreateRequest, Store.class);
        store.setActiveStore(true);
        Store saveStore = storeRepository.save(store);
        return Response.successfulResponse("Store Created Successfully", saveStore);
    }
    public Response<Store>getStoreById(long storeId ){
        var store = storeRepository.findById(storeId).orElseThrow( () -> new InstoreApplicationExceptions("Store not found with id " + storeId));
        return Response.successfulResponse("Store Fetched Successfully", store) ;
    }

    public Response<List<StoreResponse>> getAllStore(){
        var storeList = storeRepository.findAll();
        List<StoreResponse> storeResponse = storeList.stream().map(us -> modelMapper.map(us, StoreResponse.class)).toList();
        return Response.successfulResponse("Stores Fetched Successfully", storeResponse);
    }
}
