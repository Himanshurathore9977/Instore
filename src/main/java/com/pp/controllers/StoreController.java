package com.pp.controllers;

import com.pp.models.Store;
import com.pp.requests.StoreCreateRequest;
import com.pp.response.Response;
import com.pp.response.StoreResponse;
import com.pp.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Response<Store>> createStore(@RequestBody @Valid StoreCreateRequest storeCreateRequest) {
        var response = storeService.createStore(storeCreateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @GetMapping
    public ResponseEntity<Response<List<StoreResponse>>>getAllStore(){
        var response =  storeService.getAllStore() ;
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response<Store>>getStoreById(@PathVariable long id ){
        var response = storeService.getStoreById(id) ;
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


}
