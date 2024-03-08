package com.in.instore.controller;

import com.in.instore.exception.NotFoundException;
import com.in.instore.response.Response;
import com.in.instore.response.UserResponse;
import com.in.instore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<Response<UserResponse>> getUser(@PathVariable long userId) throws NotFoundException {
        var response = userService.getUserById(userId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

//    @GetMapping
//    public APIResponse<List<UserResponse>> getUser(){
//        return userService.getAllUser() ;
//    }
//
//    @PutMapping("/{id}")
//    public APIResponse<UserResponse> updateUser(@PathVariable long id, @RequestBody UserCreateRequest userRequest){
//        return userService.updateUser(id , userRequest);
//    }
//
//    @PostMapping
//    public APIResponse<UserResponse> createUser(@RequestBody UserCreateRequest userRequest ){
//        return userService.createUser(userRequest);
//    }
}
