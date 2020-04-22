package com.example.carshopbackend.Web;

import com.example.carshopbackend.domain.User;
import com.example.carshopbackend.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository repo;

    @Autowired
    public UserDetailServiceImpl(UserRepository userRepository) {
        this.repo = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = repo.findByUsername(username);

        return new org.springframework.security.core.userdetails.User(username,
                currentUser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(currentUser.getRole()));
    }
}
