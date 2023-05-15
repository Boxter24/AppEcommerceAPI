package com.Boxter24.EcommerceAPI.services;

import com.Boxter24.EcommerceAPI.models.User;
import com.Boxter24.EcommerceAPI.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User userActive = userRepository.findUserActive(email);

        if(userActive == null){
            throw new UsernameNotFoundException("User Not Found");
        }

        return userActive;

    }
}
