package com.ahmed.service;

import com.ahmed.deo.UserRepository;
import com.ahmed.dto.JwtLogin;
import com.ahmed.dto.UserPrincipal;
import com.ahmed.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(email);
        UserPrincipal userPrincipal=new UserPrincipal(user);
        return userPrincipal;
    }
    @Transactional
    public void adduser(User user){
        userRepository.save(user);
    }
}
