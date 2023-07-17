package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.Role;
import com.Boxter24.EcommerceAPI.models.User;
import com.Boxter24.EcommerceAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        var userCreate = User.builder()
                .fullname(user.getFullname())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(Role.USER)
                .build();

        return userRepository.save(userCreate);
    }

    public ResponseEntity<?> updateUser(User user){

        Map<String,Object> response = new HashMap<>();
        User userUpdate = null;

        User findUser = userRepository.findById(user.getId()).orElse(null);

        if(findUser == null){
            response.put("message","Failed to update User, the User with ID: ".concat(user.getId().toString()).concat(" do not exist"));
            return new ResponseEntity<Map<String,Object>>(response, NOT_FOUND);
        }

        try {

            findUser.setFullname(user.getFullname());
            findUser.setEmail(user.getEmail());
            findUser.setPassword(passwordEncoder.encode(user.getPassword()));

            userUpdate = userRepository.save(findUser);

        }catch (DataAccessException e){
            response.put("message","Error Updating Usuario");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, INTERNAL_SERVER_ERROR);
        }

        response.put("message","User Updated Successfully");
        response.put("data",userUpdate);

        return new ResponseEntity<Map<String ,Object>>(response, CREATED);

    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
