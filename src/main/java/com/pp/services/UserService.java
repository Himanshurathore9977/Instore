package com.pp.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.pp.requests.UserUpdateRequest;
import com.pp.util.ConstantMessages;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.pp.exceptions.InstoreApplicationExceptions;
import com.pp.models.User;
import com.pp.repository.UserRepository;
import com.pp.requests.UserCreateRequest;
import com.pp.response.Response;
import com.pp.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

     private final UserRepository userRepository;

     ModelMapper modelMapper = new ModelMapper();

    public Response<UserResponse> createUser(UserCreateRequest userCreateRequest) throws InstoreApplicationExceptions {

        if (userRepository.existsByEmail(userCreateRequest.getEmail()))
            throw new InstoreApplicationExceptions("A user with the same email already exists");

        if (userRepository.existsByUserName(userCreateRequest.getUserName()))
            throw new InstoreApplicationExceptions("A user with the same username already exists");

        if (userRepository.existsByMobileNumber(userCreateRequest.getMobileNumber()))
            throw new InstoreApplicationExceptions("A user with the same Mobile Number already exists");

        var user = modelMapper.map(userCreateRequest, User.class);
        user.setActiveUser(true);
        user.setResetPassword(user.getPassword());
        long value =  new Random().nextLong();
        while(userRepository.existsByIdentityNumber(value) || value<0 ){
            value = new Random().nextLong();
        }
        user.setIdentityNumber(value) ;

        userRepository.save(user);
        var userResponse = modelMapper.map(user, UserResponse.class);
        return Response.successfulResponse("User Created Successfully", userResponse);
    }


     public Response<User> getUserById(long userId) throws InstoreApplicationExceptions {

         var user = userRepository.findById(userId).orElseThrow(() -> new InstoreApplicationExceptions("User not found with id"));
         return Response.successfulResponse(ConstantMessages.USER_FETCH_SUCCESSFULLY, user);
     }

     public Response<List<UserResponse>> getAllUser() {
         var user = userRepository.findAll();
         List<UserResponse> userResponses = user.stream().map(us -> modelMapper.map(us, UserResponse.class)).collect(Collectors.toList());
         return Response.successfulResponse(200, "Retrieved Successfully ", userResponses);
     }




    public Response<UserResponse> updateUser(Long userId  , UserUpdateRequest userUpdateRequest) throws InstoreApplicationExceptions {

         User existingUser = userRepository.findById(userId).orElseThrow(() -> new InstoreApplicationExceptions("User not found with id  "));
         if(!userUpdateRequest.getMobileNumber().equals(existingUser.getMobileNumber())  && userRepository.existsByEmail(userUpdateRequest.getEmail()))
             throw new InstoreApplicationExceptions("A user with the same email already exists");

         if(!userUpdateRequest.getUserName().equals(existingUser.getUserName()) && userRepository.existsByUserName(userUpdateRequest.getUserName()))
             throw new InstoreApplicationExceptions("A user with the same username already exists");

         if (!userUpdateRequest.getMobileNumber().equals(existingUser.getMobileNumber()) && userRepository.existsByMobileNumber(userUpdateRequest.getMobileNumber()))
             throw new InstoreApplicationExceptions("A user with the same Mobile Number already exists");


        existingUser.setEmail(userUpdateRequest.getEmail());
        existingUser.setUserName(userUpdateRequest.getUserName());
        existingUser.setFullName(userUpdateRequest.getFullName());
        existingUser.setPassword((userUpdateRequest.getPassword()));


        existingUser.setMobileNumber(userUpdateRequest.getMobileNumber());
        existingUser.setCountry(userUpdateRequest.getCountry());
        existingUser.setResetPassword(userUpdateRequest.getPassword());

        User updatedUser = userRepository.save(existingUser);
        UserResponse userResponse = modelMapper.map(updatedUser, UserResponse.class);
        return Response.successfulResponse("User Updated Successfully", userResponse);
     }

    public Response<UserResponse> deleteUser(Long userId ){
         var user = userRepository.findById(userId).orElseThrow(() -> new InstoreApplicationExceptions("User Not Found  "));
         user.setActiveUser(false);
         userRepository.save(user);
         return  Response.successfulResponse("User Deleted Successfully ");
    }

    }
