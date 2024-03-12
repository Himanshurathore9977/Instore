package com.pp.services;

import com.pp.exceptions.InstoreApplicationExceptions;
import com.pp.models.Store;
import com.pp.models.User;
import com.pp.repository.StoreRepository;
import com.pp.requests.StoreCreateRequest;
import com.pp.requests.UserCreateRequest;
import com.pp.response.Response;
import com.pp.response.StoreResponse;
import com.pp.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository ;
    ModelMapper modelMapper = new ModelMapper();
    public Response<StoreResponse> createStore(StoreCreateRequest storeCreateRequest) throws InstoreApplicationExceptions {

        if (storeRepository.existsByStoreName(storeCreateRequest.getStoreName()))
            throw new InstoreApplicationExceptions("A Store with the same name already exists");
        var store = modelMapper.map(storeCreateRequest, Store.class);
        store.setActiveStore(true);
        storeRepository.save(store);
        var storeResponse = modelMapper.map(store, StoreResponse.class);
        return Response.successfulResponse("Store Created Successfully", storeResponse);
    }


}
