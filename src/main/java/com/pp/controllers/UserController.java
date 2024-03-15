package com.pp.controllers;

import java.util.List;

import com.pp.models.User;
import com.pp.requests.UserCreateRequest;
import com.pp.requests.UserUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pp.exceptions.InstoreApplicationExceptions;
import com.pp.response.Response;
import com.pp.response.UserResponse;
import com.pp.services.UserService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Response<UserResponse>> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        var response = userService.createUser(userCreateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<User>> getUser(@PathVariable Long id) throws InstoreApplicationExceptions {
        var response = userService.getUserById(id);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<UserResponse>>> getUser() {
        var response = userService.getAllUser();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<UserResponse>> updateUser(@PathVariable Long id, @RequestBody @Valid UserUpdateRequest userUpdateRequest) throws InstoreApplicationExceptions, IllegalAccessException {
        var response =  userService.updateUser(id, userUpdateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response) ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<UserResponse>> deleteUser(@PathVariable Long id) throws InstoreApplicationExceptions  {
        var response =  userService.deleteUser(id);
        return ResponseEntity.status(response.getStatusCode()).body(response) ;
    }
}
