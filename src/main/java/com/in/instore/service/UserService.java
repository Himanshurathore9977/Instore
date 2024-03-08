package com.in.instore.service;

import com.in.instore.exception.NotFoundException;
import com.in.instore.repository.UserRepository;
import com.in.instore.response.Response;
import com.in.instore.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    public Response<UserResponse> getUserById(long userId) throws NotFoundException {

        var user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found with id"));
        var userResponse = modelMapper.map(user, UserResponse.class);
        return Response.successfulResponse("User fetched Successfully", userResponse);
    }


//    public APIResponse<List<UserResponse>> getAllUser(){
//        try{
//            List<User> user = userRepository.findAll() ;
//            List<UserResponse> userResponses = user.stream().map(us -> modelMapper.map(us, UserResponse.class)).collect(Collectors.toList());
//            System.out.println(userResponses);
//            return new APIResponse<>(true , userResponses , "Retrieved Successfully " , 200);
//        }catch (Exception e ){
//            return new APIResponse<>(false , null  , "Failed  " , 400);
//        }
//
//    }
//
//    public APIResponse<UserResponse> createUser(UserCreateRequest userRequest){
//        try {
//            User user = modelMapper.map(userRequest , User.class);
//            if ( userRepository.existsByEmail(userRequest.getEmail())) {
//                throw new DuplicateException("A user with the same email already exists");
//            }if ( userRepository.existsByUserName(userRequest.getUserName())) {
//                throw new DuplicateException("A user with the same username already exists");
//            }if ( userRepository.existsByMobileNumber(userRequest.getMobileNumber())) {
//                throw new DuplicateException("A user with the same Mobile Number already exists");
//            }
//            userRepository.save(user) ;
//            UserResponse userResponse = modelMapper.map(user , UserResponse.class) ;
//            return new APIResponse<>(true , userResponse , "User Created  Successfully " , 200);
//        }catch (DuplicateException es ) {
//            return new APIResponse<>(false, null, es.getMessage(), 404);
//        }
//        catch (Exception e ){
//            e.printStackTrace();
//            return new APIResponse<>(true , null  , "Error in creating User  " , 400 );
//        }
//
//    }
//
//    public APIResponse<UserResponse> updateUser(Long userId  , UserCreateRequest userRequest){
//        try {
//            User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found with id  "))  ;
//            if (userRequest.getEmail()!= null && !user.getEmail().equals(userRequest.getEmail()) && userRepository.existsByEmail(userRequest.getEmail())) {
//                throw new DuplicateException("A user with the same email already exists");
//            }else{
//                user.setEmail(userRequest.getEmail());
//            }
//            if (userRequest.getUserName() != null && !user.getUserName().equals(userRequest.getUserName()) && userRepository.existsByUserName(userRequest.getUserName())) {
//                throw new DuplicateException("A user with the same username already exists");
//            }else{
//                user.setUserName(userRequest.getUserName());
//            }
//            if ( userRequest.getMobileNumber() != null && !user.getMobileNumber().equals(userRequest.getMobileNumber()) && userRepository.existsByMobileNumber(userRequest.getMobileNumber())) {
//                throw new DuplicateException("A user with the same Mobile Number already exists");
//            }else{
//                user.setEmail(userRequest.getEmail());
//            }
//
//            if (userRequest.getFullName() != null) {
//                user.setFullName(userRequest.getFullName());
//            }
//            if (userRequest.getPassword() != null) {
//                user.setPassword((userRequest.getPassword()));
//            }
////            if (userRequest.getRoles() != null) {
////                user.setRoles(userRequest.getRoles());
////            }
//            if (userRequest.getEmail() != null) {
//                user.setEmail(userRequest.getEmail());
//            }
//            System.out.println(userRequest.getMobileNumber());
//            if (userRequest.getMobileNumber() != null) {
//                user.setMobileNumber(userRequest.getMobileNumber());
//            }
//            if (userRequest.getCountry() != null) {
//                user.setCountry(userRequest.getCountry());
//            }
//            if (userRequest.getActiveUser() != null) {
//                user.setActiveUser(userRequest.getActiveUser());
//            }
////            if (userRequest.getResetPassword() != null) {
////                user.setResetPassword(userRequest.getResetPassword());
////            }
//            if (userRequest.getMerchantID() != null) {
//                user.setMerchantID(userRequest.getMerchantID());
//            }
//
//            User updatedUser = userRepository.save(user);
//            UserResponse userResponse = modelMapper.map(updatedUser, UserResponse.class);
//            return new APIResponse<UserResponse>(true , userResponse , " User Updated  Successfully  " , 201);
//
//        } catch (NotFoundException | DuplicateException es ) {
//            return new APIResponse<>(false, null, es.getMessage(), 404);
//        } catch (Exception e ){
//            return new APIResponse<>(false, null , "Error while Updating ", 404);
//        }
//    }

}
