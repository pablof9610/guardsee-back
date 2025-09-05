package com.personal.project.guardsee.security;

import com.personal.project.guardsee.model.User;
import com.personal.project.guardsee.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class ProductUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username "+username));
        return new ProductUserDetails(user);
    }
}
