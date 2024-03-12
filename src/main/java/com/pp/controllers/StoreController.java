package com.pp.controllers;

import com.pp.requests.StoreCreateRequest;
import com.pp.requests.UserCreateRequest;
import com.pp.response.Response;
import com.pp.response.StoreResponse;
import com.pp.response.UserResponse;
import com.pp.services.StoreService;
import com.pp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Response<StoreResponse>> createStore(@RequestBody @Valid StoreCreateRequest storeCreateRequest) {
        var response = storeService.createStore(storeCreateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<UserResponse>>>getAllStore(){
       var response =  storeService.getAllStore() ;
    }
}
